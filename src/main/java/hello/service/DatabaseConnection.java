package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;
import java.util.Iterator;

@Service
public class DatabaseConnection {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    private final JdbcTemplate jdbcTemplate;
    private Connection conn;

    public DatabaseConnection(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public DatabaseConnection __enter__() {
        return this;
    }

    @PreDestroy
    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                logger.debug("Database connection closed.");
            }
        } catch (SQLException e) {
            logger.error("Error closing database connection: {}", e.getMessage());
        }
    }

    public List<Map<String, Object>> query_all(String sql, Object... params) {
        logger.debug("Executing query: {} with params: {}", sql, params);
        try {
            return jdbcTemplate.queryForList(sql, params);
        } catch (DataAccessException e) {
            logger.error("Error executing query: {} with params: {}: {}", sql, params, e.getMessage());
            throw e;
        }
    }

    public Optional<Map<String, Object>> query_one(String sql, Object... params) {
        logger.debug("Executing query: {} with params: {}", sql, params);
        try {
            List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, params);
            return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
        } catch (DataAccessException e) {
            logger.error("Error executing query: {} with params: {}: {}", sql, params, e.getMessage());
            throw e;
        }
    }

    @Async
    public Iterator<DatabaseConnection> getDbConnection(HttpServletRequest request) {
        DatabaseConnection dbConnection = (DatabaseConnection) request.getAttribute("dbConnection");
        if (dbConnection == null) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Database connection not initialized");
        }
        try {
            return new Iterator<DatabaseConnection>() {
                private boolean hasNext = true;

                @Override
                public boolean hasNext() {
                    return hasNext;
                }

                @Override
                public DatabaseConnection next() {
                    hasNext = false;
                    return dbConnection;
                }
            };
        } finally {
            dbConnection.close();
        }
    }
}