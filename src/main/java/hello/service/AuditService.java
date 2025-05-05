package hello.service;

import hello.repository.AuditRepository;
import hello.dto.AuditDataDTO;

import java.util.List;

public class AuditService {
    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void createTemporaryTable() {
        String sql = "CREATE TEMPORARY TABLE #audit_data (audit_id INT, user_id INT, action VARCHAR, timestamp DATETIME, details TEXT);";
        try {
            auditRepository.executeCreateTable(sql);
        } catch (Exception e) {
            throw new RuntimeException("Error creating temporary table", e);
        }
    }

    public void insertAuditData(List<AuditDataDTO> auditRecords) {
        if (auditRecords == null || auditRecords.isEmpty()) {
            throw new IllegalArgumentException("Audit records cannot be null or empty");
        }
        String sql = "INSERT INTO #audit_data (audit_id, user_id, action, timestamp, details) VALUES (?, ?, ?, ?, ?);";
        try {
            auditRepository.executeInsertAuditData(sql, auditRecords);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting audit data", e);
        }
    }

    public List<AuditDataDTO> retrieveAuditData() {
        try {
            return auditRepository.findAllAuditData();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving audit data", e);
        }
    }

    public void cleanupTemporaryTable() {
        String sql = "DROP TABLE #audit_data;";
        try {
            auditRepository.executeCreateTable(sql);
        } catch (Exception e) {
            throw new RuntimeException("Error cleaning up temporary table", e);
        }
    }
}