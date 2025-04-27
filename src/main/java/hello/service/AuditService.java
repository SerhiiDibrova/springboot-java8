package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.AuditRepository;
import hello.repository.AuditRecordRepository;
import hello.dto.AuditDataDTO;
import java.util.List;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class AuditService {

    private final AuditRepository auditRepository;
    private final AuditRecordRepository auditRecordRepository;

    @Autowired
    public AuditService(AuditRepository auditRepository, AuditRecordRepository auditRecordRepository) {
        this.auditRepository = auditRepository;
        this.auditRecordRepository = auditRecordRepository;
    }

    public List<AuditDataDTO> insertAuditData(Integer managerId) {
        return auditRepository.findByManagerIdAndType(managerId, "SALES").stream()
            .map(audit -> {
                var records = auditRecordRepository.findByAuditId(audit.getId());
                return new AuditDataDTO(audit.getId(), records.getDetails(), audit.getCreatedAt());
            })
            .collect(Collectors.toList());
    }

    public void createTempAuditTable() {
        auditRecordRepository.createTempTable();
    }

    public void insertAuditRecord(String action, LocalDateTime timestamp, Integer userId, String details) {
        auditRecordRepository.insertRecord(action, timestamp, userId, details);
    }

    public List<AuditDataDTO> retrieveAuditData() {
        return auditRecordRepository.findAll().stream()
            .map(record -> new AuditDataDTO(record.getAuditId(), record.getDetails(), record.getCreatedAt()))
            .collect(Collectors.toList());
    }

    public void cleanupAuditTable() {
        auditRecordRepository.dropTempTable();
    }
}