package hello.service;

import hello.repository.AuditRepository;
import hello.repository.AuditRecordRepository;
import hello.dto.AuditDataDTO;
import hello.entity.Audit;
import hello.entity.AuditRecord;
import hello.exception.ManagerNotFoundException;
import hello.exception.DataRetrievalException;
import java.util.ArrayList;
import java.util.List;

public class SalesReportService {
    private final AuditRepository auditRepository;
    private final AuditRecordRepository auditRecordRepository;

    public SalesReportService(AuditRepository auditRepository, AuditRecordRepository auditRecordRepository) {
        this.auditRepository = auditRepository;
        this.auditRecordRepository = auditRecordRepository;
    }

    public List<AuditDataDTO> insertAuditData(int managerId) {
        if (managerId <= 0 || !managerExists(managerId)) {
            throw new ManagerNotFoundException("Manager ID is invalid or does not exist.");
        }

        List<AuditDataDTO> auditDataList = new ArrayList<>();
        try {
            List<Audit> audits = auditRepository.findByManagerIdAndType(managerId, "SALES");
            for (Audit audit : audits) {
                List<AuditRecord> records = auditRecordRepository.findByAuditId(audit.getId());
                for (AuditRecord record : records) {
                    AuditDataDTO dto = new AuditDataDTO();
                    dto.setAuditId(audit.getId());
                    dto.setRecordDetails(record.getDetails());
                    dto.setCreatedAt(record.getCreatedAt());
                    auditDataList.add(dto);
                }
            }
        } catch (Exception e) {
            throw new DataRetrievalException("Error retrieving audit data.", e);
        }
        return auditDataList;
    }

    private boolean managerExists(int managerId) {
        // Implement logic to check if the manager exists in the database
        return true; // Placeholder return value
    }
}