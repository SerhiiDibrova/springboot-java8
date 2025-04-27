package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import hello.repository.AuditDataRepository;
import hello.dto.AuditDataDTO;
import java.util.List;

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
            jdbcTemplate.execute("CREATE TEMPORARY TABLE audit_data (id INT, manager_id BIGINT, type VARCHAR(255), data VARCHAR(255))");
        } catch (Exception e) {
            throw new CustomException("Error creating temporary audit table", e);
        }
    }

    public void insertAuditRecord(AuditDataDTO auditDataDTO) {
        String sql = "INSERT INTO audit_data (id, manager_id, type, data) " +
                     "SELECT a.id, a.manager_id, a.type, ar.data " +
                     "FROM audit a " +
                     "JOIN audit_record ar ON a.id = ar.audit_id " +
                     "WHERE a.manager_id = ? AND a.type = 'SALES'";
        try {
            jdbcTemplate.update(sql, auditDataDTO.getManagerId());
        } catch (Exception e) {
            throw new CustomException("Error inserting audit record", e);
        }
    }

    public List<AuditDataDTO> retrieveAuditData() {
        String sql = "SELECT id, manager_id, type, data FROM audit_data";
        try {
            return jdbcTemplate.query(sql, (rs, rowNum) -> new AuditDataDTO(rs.getInt("id"), rs.getLong("manager_id"), rs.getString("type"), rs.getString("data")));
        } catch (Exception e) {
            throw new CustomException("Error retrieving audit data", e);
        }
    }

    public void cleanupAuditTable() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS audit_data");
        } catch (Exception e) {
            throw new CustomException("Error cleaning up temporary audit table", e);
        }
    }
}