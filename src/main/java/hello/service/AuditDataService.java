package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditDataService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AuditData> insertAuditData(Integer managerId) {
        try {
            setupAuditDataTable();
            String sqlInsert = "INSERT INTO #audit_data (audit_id, record_details, created_at) " +
                               "SELECT a.id, ar.details, ar.created_at " +
                               "FROM audit a " +
                               "JOIN audit_record ar ON a.id = ar.audit_id " +
                               "WHERE a.manager_id = ? AND a.type = 'SALES'";
            jdbcTemplate.update(sqlInsert, managerId);
            return executeSelectAuditData();
        } catch (Exception e) {
            handleErrors(e);
            return List.of();
        } finally {
            cleanupAuditDataTable();
        }
    }

    private void setupAuditDataTable() {
        String sqlCreate = "CREATE TEMPORARY TABLE #audit_data (audit_id BIGINT, record_details VARCHAR(MAX), created_at DATETIME)";
        jdbcTemplate.execute(sqlCreate);
    }

    private List<AuditData> executeSelectAuditData() {
        String sqlSelect = "SELECT * FROM #audit_data";
        List<AuditData> results = jdbcTemplate.query(sqlSelect, new BeanPropertyRowMapper<>(AuditData.class));
        handleQueryResults(results);
        return results;
    }

    private void handleQueryResults(List<AuditData> results) {
        if (!results.isEmpty()) {
            // Process results (e.g., display or log)
        }
    }

    private void cleanupAuditDataTable() {
        try {
            String sqlDrop = "DROP TABLE #audit_data";
            jdbcTemplate.execute(sqlDrop);
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    private void handleErrors(Exception e) {
        // Log error message
    }

    private void documentAuditData() {
        // Documentation about #audit_data structure and assumptions
    }
}