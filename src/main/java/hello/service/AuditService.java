package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.AuditRepository;
import hello.dto.AuditDataDTO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuditService {

    private final AuditRepository auditRepository;

    @Autowired
    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public List<AuditDataDTO> getAuditDataByManagerId(Integer managerId) {
        return Optional.ofNullable(auditRepository.findByManagerIdAndType(managerId, "SALES"))
            .orElse(List.of())
            .stream()
            .map(audit -> {
                var records = audit.getRecords();
                return new AuditDataDTO(audit.getId(), records.stream().map(record -> record.getDetails()).collect(Collectors.toList()), audit.getCreatedAt());
            })
            .collect(Collectors.toList());
    }
}