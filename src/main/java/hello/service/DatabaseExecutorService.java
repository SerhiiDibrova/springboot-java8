package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import java.util.List;
import java.util.Map;

@Service
public class DatabaseExecutorService {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(DatabaseExecutorService.class);

    @Autowired
    public DatabaseExecutorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void execute(String query, Object... params) {
        logger.debug("Executing query: {} with params: {}", query, params);
        try {
            jdbcTemplate.update(query, params);
        } catch (DataAccessException e) {
            logger.error("Error executing query: {}", query, e);
            throw e;
        }
    }

    public List<Map<String, Object>> queryAll(String query, Object... params) {
        logger.debug("Executing query: {} with params: {}", query, params);
        try {
            return jdbcTemplate.queryForList(query, params);
        } catch (DataAccessException e) {
            logger.error("Error executing query: {}", query, e);
            throw e;
        }
    }

    public <T> T queryForObject(String query, Class<T> requiredType, Object... params) {
        logger.debug("Executing query for single object: {} with params: {}", query, params);
        try {
            return jdbcTemplate.queryForObject(query, requiredType, params);
        } catch (DataAccessException e) {
            logger.error("Error executing query: {}", query, e);
            throw e;
        }
    }
}