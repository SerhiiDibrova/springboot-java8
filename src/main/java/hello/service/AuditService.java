package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class AuditService {

    private final AuditRepository auditRepository;
    private final AuditRecordRepository auditRecordRepository;
    private final AuditDataRepository auditDataRepository;

    @Autowired
    public AuditService(AuditRepository auditRepository, AuditRecordRepository auditRecordRepository, AuditDataRepository auditDataRepository) {
        this.auditRepository = auditRepository;
        this.auditRecordRepository = auditRecordRepository;
        this.auditDataRepository = auditDataRepository;
    }

    public List<AuditDataDTO> insertAuditData(Integer managerId) {
        try {
            return auditDataRepository.findByManagerIdAndType(managerId, "SALES");
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving audit data for managerId: " + managerId, e);
        }
    }

    public void createTempAuditTable() {
        try {
            auditRecordRepository.createTempTable();
        } catch (Exception e) {
            throw new RuntimeException("Error creating temporary audit table", e);
        }
    }

    public void insertAuditRecord(String action, LocalDateTime timestamp, Integer userId, String details) {
        try {
            auditRecordRepository.insertRecord(action, timestamp, userId, details);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting audit record", e);
        }
    }

    public List<AuditDataDTO> retrieveAuditData() {
        try {
            return auditDataRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving audit data", e);
        }
    }

    public void cleanupAuditTable() {
        try {
            auditRecordRepository.dropTempTable();
        } catch (Exception e) {
            throw new RuntimeException("Error cleaning up temporary audit table", e);
        }
    }
}