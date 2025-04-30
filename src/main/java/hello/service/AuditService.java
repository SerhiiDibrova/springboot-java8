package hello.service;

import hello.repository.AuditRepository;
import hello.repository.AuditRecordRepository;
import hello.repository.AuditDataRepository;
import hello.service.ErrorLogService;
import hello.model.Audit;
import hello.model.AuditRecord;
import hello.model.AuditData;
import hello.model.AuditDataDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuditService {
    private final AuditRepository auditRepository;
    private final AuditRecordRepository auditRecordRepository;
    private final AuditDataRepository auditDataRepository;
    private final ErrorLogService errorLogService;

    public AuditService(AuditRepository auditRepository, AuditRecordRepository auditRecordRepository, 
                        AuditDataRepository auditDataRepository, ErrorLogService errorLogService) {
        this.auditRepository = auditRepository;
        this.auditRecordRepository = auditRecordRepository;
        this.auditDataRepository = auditDataRepository;
        this.errorLogService = errorLogService;
    }

    public List<AuditDataDTO> insertAuditData(Integer managerId) {
        if (managerId == null) {
            throw new IllegalArgumentException("Manager ID cannot be null");
        }
        List<Audit> audits = auditRepository.findByManagerIdAndType(managerId, "SALES");
        List<AuditDataDTO> auditDataList = new ArrayList<>();
        for (Audit audit : audits) {
            List<AuditRecord> records = auditRecordRepository.findByAuditId(audit.getId());
            for (AuditRecord record : records) {
                AuditDataDTO dto = new AuditDataDTO(audit.getId(), record.getDetails(), record.getCreatedAt());
                auditDataList.add(dto);
            }
        }
        insertAuditData(auditDataList);
        return auditDataList;
    }

    public void setupAuditDataTable() {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TEMPORARY TABLE #audit_data (auditId LONG, recordDetails STRING, createdAt TIMESTAMP)");
        } catch (SQLException e) {
            handleErrors(e);
        }
    }

    public void insertAuditData(List<AuditData> auditDataList) {
        for (AuditData auditData : auditDataList) {
            auditDataRepository.save(auditData);
        }
    }

    public List<AuditData> executeSelectAuditData() {
        return auditDataRepository.findAll();
    }

    public void handleQueryResults(List<AuditData> results) {
        if (!results.isEmpty()) {
            results.forEach(result -> System.out.println(result));
        }
    }

    public void cleanupAuditDataTable() {
        try (Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
             Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE #audit_data");
        } catch (SQLException e) {
            handleErrors(e);
        }
    }

    public void handleErrors(Exception error) {
        errorLogService.logError(error.getMessage(), 1, 0);
    }
}