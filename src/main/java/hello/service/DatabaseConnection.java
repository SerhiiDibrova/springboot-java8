package hello.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class DatabaseConnection {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    private final Connection conn;
    private final JdbcTemplate jdbcTemplate;

    public DatabaseConnection(String dsn, JdbcTemplate jdbcTemplate) {
        this.conn = initializeConnection(dsn);
        this.jdbcTemplate = jdbcTemplate;
        logger.info("Database connection established.");
    }

    private Connection initializeConnection(String dsn) {
        try {
            return DriverManager.getConnection(dsn);
        } catch (SQLException e) {
            logger.error("Error initializing database connection: ", e);
            throw new RuntimeException("Failed to initialize database connection", e);
        }
    }

    public DatabaseConnection enter() {
        return this;
    }

    @PreDestroy
    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                logger.info("Database connection closed.");
            }
        } catch (SQLException e) {
            logger.error("Error closing database connection: ", e);
        }
    }

    public List<Map<String, Object>> queryAll(String sql, Object... params) {
        logger.debug("Executing query: {} with params: {}", sql, params);
        try {
            return jdbcTemplate.queryForList(sql, params != null ? params : new Object[]{});
        } catch (DataAccessException e) {
            logger.error("Error executing query: ", e);
            return List.of();
        }
    }

    public Optional<Map<String, Object>> query_one(String sql, Object... params) {
        logger.debug("Executing single query: {} with params: {}", sql, params);
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, params != null ? params : new Object[]{}, Map.class));
        } catch (DataAccessException e) {
            logger.error("Error executing single query: ", e);
            return Optional.empty();
        }
    }

    public CompletableFuture<DatabaseConnection> getDbConnection(HttpServletRequest request) {
        return CompletableFuture.supplyAsync(() -> {
            DatabaseConnection dbConnection = (DatabaseConnection) request.getAttribute("dbConnection");
            if (dbConnection == null) {
                throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Database connection not initialized");
            }
            return dbConnection;
        }).whenComplete((result, throwable) -> {
            if (throwable != null) {
                logger.error("Error retrieving database connection: ", throwable);
            }
        });
    }
}