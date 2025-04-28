package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class DatabaseExecutor {
    private final DataSource conn;
    private static final Logger logger = LoggerFactory.getLogger(DatabaseExecutor.class);
    private final JdbcTemplate jdbcTemplate;

    public DatabaseExecutor(DataSource conn) {
        this.conn = conn;
        this.jdbcTemplate = new JdbcTemplate(conn);
    }

    public void execute(String query, Object... params) {
        logger.debug("Executing query: {} with parameters: {}", query, params);
        try {
            jdbcTemplate.update(query, params);
        } catch (Exception e) {
            logger.error("Error executing query: {}", e.getMessage(), e);
        }
    }
}