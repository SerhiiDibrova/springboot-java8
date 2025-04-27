package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import hello.repository.AuditDataRepository;

@Service
public class AuditDataService {

    private final AuditDataRepository auditDataRepository;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuditDataService(AuditDataRepository auditDataRepository, JdbcTemplate jdbcTemplate) {
        this.auditDataRepository = auditDataRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTempAuditTable() {
        try {
            jdbcTemplate.execute("CREATE TABLE #audit_data (id INT, manager_id LONG, type VARCHAR(255), data VARCHAR(255))");
        } catch (Exception e) {
            throw new RuntimeException("Error creating temporary audit table", e);
        }
    }

    public void insertAuditRecord(Long managerId) {
        String sql = "INSERT INTO #audit_data (id, manager_id, type, data) " +
                     "SELECT a.id, a.manager_id, a.type, ar.data " +
                     "FROM audit a " +
                     "JOIN audit_record ar ON a.id = ar.audit_id " +
                     "WHERE a.manager_id = ? AND a.type = 'SALES'";
        try {
            jdbcTemplate.update(sql, managerId);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting audit record", e);
        }
    }

    public void cleanupAuditTable() {
        try {
            jdbcTemplate.execute("DROP TABLE #audit_data");
        } catch (Exception e) {
            throw new RuntimeException("Error cleaning up temporary audit table", e);
        }
    }
}