package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public List<AuditData> getAuditData(Integer managerId) {
        if (Objects.isNull(managerId) || managerId <= 0) {
            throw new IllegalArgumentException("Invalid managerId");
        }
        List<AuditData> auditDataList = auditRepository.findAuditDataByManagerId(managerId);
        return transformAuditData(auditDataList);
    }

    private List<AuditData> transformAuditData(List<AuditData> auditDataList) {
        // Implement necessary transformations here
        return auditDataList;
    }
}