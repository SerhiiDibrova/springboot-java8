package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hello.repository.AuditDataRepository;
import hello.dto.AuditDataDTO;
import hello.entity.AuditData;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditDataService {

    @Autowired
    private AuditDataRepository auditDataRepository;

    @Transactional
    public void insertAuditData(Long managerId) {
        try {
            String sql = "INSERT INTO #audit_data (SELECT * FROM audit a JOIN audit_record ar ON a.id = ar.audit_id WHERE a.manager_id = :managerId AND a.category = 'SALES')";
            auditDataRepository.executeNativeQuery(sql, managerId);
        } catch (Exception e) {
            // Handle exception (e.g., log the error, rethrow a custom exception)
        }
    }

    public List<AuditDataDTO> retrieveAuditData() {
        List<AuditData> auditDataList = auditDataRepository.findAll();
        return auditDataList.stream()
                .filter(this::isValidAuditData)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private boolean isValidAuditData(AuditData auditData) {
        return auditData.getManagerId() != null && auditData.getCategory() != null;
    }

    private AuditDataDTO convertToDTO(AuditData auditData) {
        AuditDataDTO dto = new AuditDataDTO();
        dto.setId(auditData.getId());
        dto.setManagerId(auditData.getManagerId());
        dto.setCategory(auditData.getCategory());
        return dto;
    }

    private AuditData convertToEntity(AuditDataDTO dto) {
        AuditData auditData = new AuditData();
        auditData.setId(dto.getId());
        auditData.setManagerId(dto.getManagerId());
        auditData.setCategory(dto.getCategory());
        return auditData;
    }
}