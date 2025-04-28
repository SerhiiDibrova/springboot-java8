package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.jdbc.datasource.DataSourceUtils;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Optional;
import java.util.Map;
import org.springframework.jdbc.DataAccessException;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Service
public class DatabaseConnectionService {
    private final Logger logger = LoggerFactory.getLogger(DatabaseConnectionService.class);
    private final Connection conn;
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public DatabaseConnectionService(Connection conn, DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.conn = conn;
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public DatabaseConnectionService enter() {
        return this;
    }

    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                logger.debug("Database connection closed");
            }
        } catch (SQLException e) {
            logger.error("Error closing the database connection", e);
        }
    }

    public CompletionStage<Connection> getDbConnection() {
        return CompletableFuture.supplyAsync(() -> {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            Connection connection = null;
            try {
                connection = DataSourceUtils.getConnection(dataSource);
                if (connection == null) {
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to obtain a database connection");
                }
                return connection;
            } catch (SQLException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error obtaining database connection", e);
            } finally {
                if (connection != null) {
                    DataSourceUtils.releaseConnection(connection, dataSource);
                }
            }
        });
    }

    /**
     * Retrieves the current database connection object.
     * @return the current Connection object
     */
    public Connection getConnection() {
        return conn;
    }

    public Optional<Map<String, Object>> query_one(String sql, Object... params) {
        try {
            logger.debug("Executing query: {}", sql);
            Optional<Map<String, Object>> result = Optional.ofNullable(jdbcTemplate.queryForMap(sql, params));
            if (!result.isPresent()) {
                logger.warn("No results found for query: {}", sql);
            }
            return result;
        } catch (DataAccessException e) {
            logger.error("Error executing query", e);
            return Optional.empty();
        }
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/yourdb");
        dataSource.setUsername("yourusername");
        dataSource.setPassword("yourpassword");
        return dataSource;
    }
}