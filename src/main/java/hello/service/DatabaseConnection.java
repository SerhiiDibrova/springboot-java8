package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DatabaseConnection {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConnection.class);
    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;
    private Connection connection;

    public DatabaseConnection(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public DatabaseConnection enter() {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("Error obtaining connection: {}", e.getMessage());
        }
        return this;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                logger.debug("Connection closed successfully.");
            }
        } catch (SQLException e) {
            logger.error("Error closing connection: {}", e.getMessage());
        }
    }

    public void execute(String query, Object... params) {
        logger.debug("Executing query: {} with params: {}", query, params);
        try {
            jdbcTemplate.update(query, params);
        } catch (Exception e) {
            logger.error("Error executing query: {} with params: {}. Error: {}", query, params, e.getMessage());
        }
    }

    public List<Map<String, Object>> query_all(String query, Object... params) {
        logger.debug("Executing query: {} with params: {}", query, params);
        try {
            return jdbcTemplate.queryForList(query, params != null ? params : new Object[]{});
        } catch (Exception e) {
            logger.error("Error executing query: {} with params: {}. Error: {}", query, params, e.getMessage());
            return List.of();
        }
    }

    public Optional<Map<String, Object>> queryOne(String query, Object... params) {
        logger.debug("Executing query: {} with params: {}", query, params);
        try {
            Map<String, Object> result = jdbcTemplate.queryForMap(query, params != null ? params : new Object[]{});
            return Optional.ofNullable(result);
        } catch (Exception e) {
            logger.error("Error executing query: {} with params: {}. Error: {}", query, params, e.getMessage());
            return Optional.empty();
        }
    }
}