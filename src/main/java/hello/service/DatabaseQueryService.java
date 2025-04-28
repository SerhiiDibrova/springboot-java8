package hello.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class DatabaseQueryService {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseQueryService.class);
    private final JdbcTemplate jdbcTemplate;

    public DatabaseQueryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> queryAll(String sql, Object... params) {
        if (sql == null || sql.trim().isEmpty()) {
            throw new IllegalArgumentException("SQL query must not be null or empty");
        }
        logger.debug("Executing query: {} with parameters: {}", sql, params);
        try {
            validateSql(sql);
            return jdbcTemplate.queryForList(sql, params);
        } catch (SQLException e) {
            logger.error("Error executing query: {}", sql, e);
            throw new DatabaseQueryException("Database query execution failed", e);
        }
    }

    private void validateSql(String sql) {
        // Basic validation to prevent SQL injection risks
        if (!sql.trim().toLowerCase().startsWith("select")) {
            throw new IllegalArgumentException("Only SELECT queries are allowed");
        }
    }
}

class DatabaseQueryException extends RuntimeException {
    public DatabaseQueryException(String message, Throwable cause) {
        super(message, cause);
    }
}