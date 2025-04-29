package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuditDataService {

    @Autowired
    private AuditRepository auditRepository;

    @Autowired
    private AuditRecordRepository auditRecordRepository;

    @Autowired
    private AuditDataRepository auditDataRepository;

    @Transactional
    public void setupAuditDataTable() {
        String sql = "IF OBJECT_ID('tempdb..#audit_data') IS NULL " +
                     "CREATE TABLE #audit_data (audit_id INT, record_details VARCHAR(255), created_at TIMESTAMP)";
        auditDataRepository.executeSql(sql);
    }

    @Transactional
    public List<AuditDataDTO> insertAuditData(Integer managerId) {
        setupAuditDataTable();
        String sql = "INSERT INTO #audit_data (audit_id, record_details, created_at) " +
                     "SELECT audit.id, audit_record.details, audit.created_at " +
                     "FROM Audit audit " +
                     "JOIN AuditRecord audit_record ON audit.id = audit_record.audit_id " +
                     "WHERE audit.manager_id = ? AND audit.type = 'SALES'";
        auditDataRepository.executeSqlWithParams(sql, managerId);
        return executeSelectAuditData();
    }

    public List<AuditDataDTO> executeSelectAuditData() {
        String sql = "IF OBJECT_ID('tempdb..#audit_data') IS NOT NULL " +
                     "SELECT * FROM #audit_data";
        return auditDataRepository.executeSelect(sql);
    }

    public void handleQueryResults(List<AuditDataDTO> results) {
        if (!results.isEmpty()) {
            // Process results
        }
    }

    @Transactional
    public void cleanupAuditDataTable() {
        String sql = "IF OBJECT_ID('tempdb..#audit_data') IS NOT NULL " +
                     "DROP TABLE #audit_data";
        auditDataRepository.executeSql(sql);
    }

    public void handleErrors(Exception e) {
        // Log error
        // Example: logger.error("Error occurred: {}", e.getMessage());
    }
}