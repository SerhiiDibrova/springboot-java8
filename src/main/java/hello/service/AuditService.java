package hello.service;

import hello.repository.AuditRepository;
import hello.dto.AuditDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class AuditService {

    private final AuditRepository auditRepository;
    private final JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(AuditService.class);

    @Autowired
    public AuditService(AuditRepository auditRepository, JdbcTemplate jdbcTemplate) {
        this.auditRepository = auditRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertAuditData(Integer managerId) {
        if (managerId == null || managerId < 0) {
            throw new IllegalArgumentException("Invalid managerId");
        }
        String createTempTableSQL = "CREATE TABLE #audit_data (audit_id INT, record_details VARCHAR(MAX), created_at DATETIME)";
        String insertSQL = "INSERT INTO #audit_data (audit_id, record_details, created_at) " +
                           "SELECT a.id, ar.details, ar.created_at " +
                           "FROM audit a " +
                           "JOIN audit_record ar ON a.id = ar.audit_id " +
                           "WHERE a.manager_id = ? AND a.type = 'SALES'";
        try {
            jdbcTemplate.execute(createTempTableSQL);
            jdbcTemplate.update(insertSQL, managerId);
        } catch (Exception e) {
            logger.error("Error inserting audit data for managerId: {}", managerId, e);
            throw new RuntimeException("Error inserting audit data for manager", e);
        }
    }

    public List<AuditDataDTO> retrieveAuditData(Integer managerId) {
        if (managerId == null || managerId < 0) {
            throw new IllegalArgumentException("Invalid managerId");
        }
        String createTableSql = "CREATE TEMPORARY TABLE #audit_data (" +
                                 "audit_id INT, " +
                                 "user_id INT, " +
                                 "action VARCHAR(255), " +
                                 "timestamp DATETIME, " +
                                 "details TEXT)";
        jdbcTemplate.execute(createTableSql);
        insertAuditData(managerId);
        String selectSql = "SELECT * FROM #audit_data";
        List<AuditDataDTO> result = jdbcTemplate.query(selectSql, (rs, rowNum) -> new AuditDataDTO(rs.getInt("audit_id"), rs.getInt("user_id"), rs.getString("action"), rs.getTimestamp("timestamp").toLocalDateTime(), rs.getString("details")));
        jdbcTemplate.execute("DROP TABLE #audit_data");
        return result;
    }
}