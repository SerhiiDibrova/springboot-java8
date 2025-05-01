package hello.service;

import hello.repository.AuditDataRepository;
import hello.exception.AuditDataServiceException;
import hello.model.AuditData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditDataService {
    private static final Logger logger = LoggerFactory.getLogger(AuditDataService.class);
    private final AuditDataRepository auditDataRepository;

    @Autowired
    public AuditDataService(AuditDataRepository auditDataRepository) {
        this.auditDataRepository = auditDataRepository;
    }

    public void insertAuditData(Integer managerId, String auditId, String recordDetails) {
        if (managerId == null || managerId < 0) {
            throw new IllegalArgumentException("Invalid manager ID");
        }
        if (auditId == null || recordDetails == null || recordDetails.isEmpty()) {
            throw new IllegalArgumentException("auditId and recordDetails must not be null or empty");
        }
        LocalDateTime timestamp = LocalDateTime.now();
        try {
            auditDataRepository.insertAuditData(auditId, recordDetails, timestamp);
        } catch (Exception e) {
            logger.error("Error inserting audit data", e);
            throw new AuditDataServiceException("Failed to insert audit data", e);
        }
    }

    public List<AuditData> getAllAuditData() {
        return auditDataRepository.findAllAuditData();
    }
}