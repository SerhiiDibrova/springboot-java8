package hello.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.nativejdbc.NativeJdbcExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class DatabaseConnection {

    private final JdbcTemplate jdbcTemplate;
    private final NativeJdbcExtractor nativeJdbcExtractor;
    private final Logger logger;

    public DatabaseConnection(DataSource dataSource, NativeJdbcExtractor nativeJdbcExtractor) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.nativeJdbcExtractor = nativeJdbcExtractor;
        this.logger = LoggerFactory.getLogger(DatabaseConnection.class);
    }

    public List<Map<String, Object>> queryAll(String query, Object params) {
        logger.debug("Executing query: {} with params: {}", query, params);
        try {
            if (params instanceof Map) {
                return jdbcTemplate.queryForList(query, (Map<String, Object>) params);
            } else if (params instanceof List) {
                return jdbcTemplate.queryForList(query, (List<Object>) params);
            } else {
                throw new RuntimeException("Unsupported params type");
            }
        } catch (Exception e) {
            logger.error("Error executing query", e);
            throw new RuntimeException(e);
        }
    }

    public List<Map<String, Object>> queryAll(String query, Object[] params) {
        logger.debug("Executing query: {} with params: {}", query, params);
        try {
            return jdbcTemplate.queryForList(query, params);
        } catch (Exception e) {
            logger.error("Error executing query", e);
            throw new RuntimeException(e);
        }
    }

    public List<Map<String, Object>> queryAll(String query, Map<String, Object> params) {
        logger.debug("Executing query: {} with params: {}", query, params);
        try {
            return jdbcTemplate.queryForList(query, params);
        } catch (Exception e) {
            logger.error("Error executing query", e);
            throw new RuntimeException(e);
        }
    }

    public List<Map<String, Object>> queryAll(String query) {
        logger.debug("Executing query: {}", query);
        try {
            return jdbcTemplate.queryForList(query);
        } catch (Exception e) {
            logger.error("Error executing query", e);
            throw new RuntimeException(e);
        }
    }

    public static class RowMapperImpl implements RowMapper<Map<String, Object>> {
        @Override
        public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
            Map<String, Object> row = new java.util.HashMap<>();
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                row.put(rs.getMetaData().getColumnName(i), rs.getObject(i));
            }
            return row;
        }
    }
}