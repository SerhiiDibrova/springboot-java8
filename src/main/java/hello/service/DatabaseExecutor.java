package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

public class DatabaseExecutor {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseExecutor.class);
    private final JdbcTemplate conn;

    public DatabaseExecutor(JdbcTemplate conn) {
        this.conn = conn;
    }

    @Transactional
    public boolean execute(String query, Object... params) {
        logger.debug("Executing query: {} with params: {}", query, params);
        try {
            validateQuery(query);
            conn.update(query, params);
            return true;
        } catch (DataAccessException e) {
            logger.error("Error executing query: {} with params: {}", query, params, e);
            return false;
        }
    }

    private void validateQuery(String query) {
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Query must not be null or empty");
        }
        // Additional validation logic can be added here
    }
}