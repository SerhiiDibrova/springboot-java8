package hello.service;

import hello.repository.AuditDataRepository;
import hello.repository.AuditRecordRepository;
import hello.entity.Audit;
import hello.entity.AuditData;
import hello.entity.AuditRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuditDataService {
    private final AuditDataRepository auditDataRepository;
    private final AuditRecordRepository auditRecordRepository;
    private final Connection connection;

    public AuditDataService(AuditDataRepository auditDataRepository, AuditRecordRepository auditRecordRepository, Connection connection) {
        this.auditDataRepository = auditDataRepository;
        this.auditRecordRepository = auditRecordRepository;
        this.connection = connection;
    }

    public void setupAuditDataTable() {
        String sql = "CREATE TEMPORARY TABLE #audit_data (id BIGINT PRIMARY KEY, details VARCHAR(255), createdAt TIMESTAMP)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        } catch (SQLException ex) {
            handleErrors(ex);
        }
    }

    public void insertAuditData(Integer managerId) {
        if (managerId == null || managerId <= 0) {
            throw new IllegalArgumentException("Invalid manager ID");
        }
        List<Audit> audits = auditDataRepository.findByManagerIdAndType(managerId, "SALES");
        for (Audit audit : audits) {
            List<AuditRecord> records = auditRecordRepository.findByAuditId(audit.getId());
            for (AuditRecord record : records) {
                AuditData auditData = new AuditData();
                auditData.setAuditId(audit.getId());
                auditData.setRecordDetails(record.getDetails());
                auditData.setCreatedAt(record.getCreatedAt());
                auditDataRepository.save(auditData);
            }
        }
    }

    public List<AuditData> executeSelectAuditData() {
        String sql = "SELECT * FROM #audit_data";
        List<AuditData> results = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                AuditData auditData = new AuditData();
                auditData.setAuditId(resultSet.getLong("id"));
                auditData.setRecordDetails(resultSet.getString("details"));
                auditData.setCreatedAt(resultSet.getTimestamp("createdAt"));
                results.add(auditData);
            }
        } catch (SQLException ex) {
            handleErrors(ex);
        }
        return results;
    }

    public void handleQueryResults(List<AuditData> results) {
        if (!results.isEmpty()) {
            // Process results
        }
    }

    public void cleanupAuditDataTable() {
        String sql = "DROP TABLE #audit_data";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        } catch (SQLException ex) {
            handleErrors(ex);
        }
    }

    public void handleErrors(Exception ex) {
        // Log error message
        System.err.println(ex.getMessage());
    }
}