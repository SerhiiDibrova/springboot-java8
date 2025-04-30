package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditDataService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuditDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void setupAuditDataTable() {
        String sql = "CREATE TABLE audit_data (audit_id INT, record_details VARCHAR(255), created_at TIMESTAMP)";
        jdbcTemplate.execute(sql);
    }

    @Transactional
    public void insertAuditData(Integer managerId) {
        if (managerId == null) {
            throw new IllegalArgumentException("Manager ID cannot be null");
        }
        List<AuditData> auditDataList = new ArrayList<>();
        String sql = "INSERT INTO audit_data (audit_id, record_details, created_at) " +
                     "SELECT audit.id, audit_record.details, audit.created_at " +
                     "FROM audit " +
                     "JOIN audit_record ON audit.id = audit_record.audit_id " +
                     "WHERE audit_record.manager_id = ? AND audit.type = 'SALES'";
        try {
            int rowsAffected = jdbcTemplate.update(sql, managerId);
            if (rowsAffected == 0) {
                throw new RuntimeException("No records found for the given manager ID");
            }
        } catch (Exception e) {
            // Log error
            throw new RuntimeException("Error inserting audit data", e);
        }
    }

    public List<AuditData> executeSelectAuditData() {
        String sql = "SELECT * FROM audit_data";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            AuditData auditData = new AuditData();
            auditData.setAuditId(rs.getInt("audit_id"));
            auditData.setRecordDetails(rs.getString("record_details"));
            auditData.setCreatedAt(rs.getTimestamp("created_at"));
            return auditData;
        });
    }

    public void handleQueryResults(List<AuditData> results) {
        if (!results.isEmpty()) {
            results.forEach(auditData -> {
                // Process each auditData object as needed
            });
        }
    }

    @Transactional
    public void cleanupAuditDataTable() {
        String sql = "DROP TABLE IF EXISTS audit_data";
        jdbcTemplate.execute(sql);
    }
}