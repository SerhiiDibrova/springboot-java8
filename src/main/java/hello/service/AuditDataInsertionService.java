package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.repository.AuditDataInsertionRepository;

@Service
public class AuditDataInsertionService {

    private static final Logger logger = LoggerFactory.getLogger(AuditDataInsertionService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AuditDataInsertionRepository auditDataInsertionRepository;

    public void insertAuditData(int managerId) {
        String createTempTable = "CREATE TABLE #audit_data (id INT, action VARCHAR(255), timestamp DATETIME)";
        String insertData = "INSERT INTO #audit_data (id, action, timestamp) " +
                            "SELECT a.id, ar.action, ar.timestamp " +
                            "FROM audit a " +
                            "JOIN audit_record ar ON a.id = ar.audit_id " +
                            "WHERE a.manager_id = ?";
        String selectData = "SELECT * FROM #audit_data";
        String dropTempTable = "DROP TABLE IF EXISTS #audit_data";

        try {
            jdbcTemplate.execute(createTempTable);
            jdbcTemplate.update(insertData, managerId);
            jdbcTemplate.query(selectData, (rs, rowNum) -> {
                // Process the result set if needed
                return null;
            });
        } catch (Exception e) {
            logger.error("Error inserting audit data: {}", e.getMessage(), e);
        } finally {
            jdbcTemplate.execute(dropTempTable);
        }
    }
}