

package hello.service;

import hello.repository.AuditRepository;
import hello.entity.AuditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditService {

    private final AuditRepository auditRepository;

    @Autowired
    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public boolean checkIfAuditNeeded(int managerId, boolean isAuditRequired) {
        return isAuditRequired && managerId > 0;
    }

    public int getDefaultManagerId() {
        return 1;
    }

    public List<AuditEntity> performAudit(int managerId, boolean isAuditRequired) {
        if (checkIfAuditNeeded(managerId, isAuditRequired)) {
            try {
                return auditRepository.findByManagerId(managerId);
            } catch (Exception e) {
                // handle exception
                return List.of();
            }
        }
        return List.of();
    }
}