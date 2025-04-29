package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditDataService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AuditDataRepository auditDataRepository;

    @Autowired
    private AuditRecordRepository auditRecordRepository;

    public List<AuditDataDTO> insertAuditData(Integer managerId) {
        List<AuditDataDTO> auditDataList = new ArrayList<>();
        try {
            setupAuditDataTable();
            String sqlInsert = "INSERT INTO #audit_data (audit_id, record_details, created_at) " +
                               "SELECT a.id, ar.details, ar.created_at " +
                               "FROM audit a " +
                               "JOIN audit_record ar ON a.id = ar.audit_id " +
                               "WHERE a.manager_id = ? AND a.type = 'SALES'";
            jdbcTemplate.update(sqlInsert, managerId);
            auditDataList = executeSelectAuditData();
        } catch (Exception e) {
            handleErrors(e);
        } finally {
            cleanupAuditDataTable();
        }
        return auditDataList;
    }

    private void setupAuditDataTable() {
        String sqlCreate = "CREATE TEMPORARY TABLE #audit_data (audit_id BIGINT, record_details VARCHAR(MAX), created_at DATETIME)";
        jdbcTemplate.execute(sqlCreate);
    }

    private List<AuditDataDTO> executeSelectAuditData() {
        String sqlSelect = "SELECT * FROM #audit_data";
        List<AuditData> results = jdbcTemplate.query(sqlSelect, new BeanPropertyRowMapper<>(AuditData.class));
        return mapToAuditDataDTO(results);
    }

    private List<AuditDataDTO> mapToAuditDataDTO(List<AuditData> results) {
        List<AuditDataDTO> dtoList = new ArrayList<>();
        for (AuditData record : results) {
            AuditDataDTO dto = new AuditDataDTO();
            dto.setAuditId(record.getId());
            dto.setRecordDetails(record.getRecordDetails());
            dto.setCreatedAt(record.getCreatedAt());
            dtoList.add(dto);
        }
        handleQueryResults(dtoList);
        return dtoList;
    }

    private void handleQueryResults(List<AuditDataDTO> results) {
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