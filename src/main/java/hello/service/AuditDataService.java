package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuditDataService {
    @Autowired
    private AuditDataRepository auditDataRepository;

    public List<AuditData> getAuditDataByManagerId(Integer managerId) {
        if (managerId == null) {
            throw new IllegalArgumentException("Manager ID must not be null");
        }
        return auditDataRepository.findByManagerIdAndType(managerId, "SALES");
    }
}