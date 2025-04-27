package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;
import hello.model.AuditData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuditDataService {
    private static final Logger logger = LoggerFactory.getLogger(AuditDataService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertAuditRecord(String action, LocalDateTime timestamp, int userId, String details) {
        if (action == null || details == null) {
            logger.error("Action and details cannot be null");
            return;
        }
        String sql = "INSERT INTO #audit_data (action, timestamp, user_id, details) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, action, timestamp, userId, details);
    }

    public List<AuditData> retrieveAuditData() {
        String sql = "SELECT * FROM #audit_data";
        List<AuditData> auditDataList = jdbcTemplate.query(sql, (rs, rowNum) -> new AuditData(rs.getString("action"), 
                                                                                                 rs.getTimestamp("timestamp").toLocalDateTime(), 
                                                                                                 rs.getInt("user_id"), 
                                                                                                 rs.getString("details")));
        if (auditDataList.isEmpty()) {
            logger.warn("No audit records found.");
        }
        return auditDataList;
    }

    public void cleanupAuditTable() {
        String sql = "DROP TABLE IF EXISTS #audit_data";
        jdbcTemplate.execute(sql);
    }

    public void insertAuditData(int managerId) {
        String createTableSql = "CREATE TABLE #audit_data AS " +
                                 "SELECT * FROM audit a " +
                                 "JOIN audit_record ar ON a.id = ar.audit_id " +
                                 "WHERE ar.manager_id = ? AND a.type = 'SALES'";
        jdbcTemplate.update(createTableSql, managerId);
    }

    public void handleErrors(Exception e) {
        logger.error("An error occurred: ", e);
    }
}