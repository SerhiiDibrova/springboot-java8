package hello.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Service
public class AuditService {
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(AuditService.class);

    public AuditService(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createTemporaryAuditTable() {
        String sql = "CREATE TEMPORARY TABLE temp_audit (id SERIAL PRIMARY KEY, manager_id INT, action VARCHAR(255), timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
        try {
            jdbcTemplate.execute(sql);
            logger.info("Temporary audit table created successfully.");
        } catch (Exception e) {
            logger.error("Error creating temporary audit table: ", e);
        }
    }

    public void insertAuditData(int managerId, String action) {
        String sql = "INSERT INTO temp_audit (manager_id, action) VALUES (?, ?)";
        try {
            jdbcTemplate.update(sql, managerId, action);
            logger.info("Inserted audit data for manager ID: {}", managerId);
        } catch (Exception e) {
            logger.error("Error inserting audit data: ", e);
        }
    }

    public List<Map<String, Object>> retrieveAuditData() {
        String sql = "SELECT * FROM temp_audit";
        try {
            List<Map<String, Object>> auditData = jdbcTemplate.queryForList(sql);
            logger.info("Retrieved audit data successfully.");
            return auditData;
        } catch (Exception e) {
            logger.error("Error retrieving audit data: ", e);
            return null;
        }
    }

    public void cleanupTemporaryAuditTable() {
        String sql = "DROP TABLE IF EXISTS temp_audit";
        try {
            jdbcTemplate.execute(sql);
            logger.info("Temporary audit table cleaned up successfully.");
        } catch (Exception e) {
            logger.error("Error cleaning up temporary audit table: ", e);
        }
    }
}