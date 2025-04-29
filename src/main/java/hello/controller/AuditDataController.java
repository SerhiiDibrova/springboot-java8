package hello.controller;

import hello.dto.AuditDataDTO;
import hello.service.AuditDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
public class AuditDataController {

    private final AuditDataService auditDataService;

    @Autowired
    public AuditDataController(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;
    }

    @PostMapping("/audit-data")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<List<AuditDataDTO>> createAuditData(@RequestParam @NotNull Integer managerId) {
        auditDataService.insertAuditData(managerId);
        List<AuditDataDTO> auditDataList = auditDataService.executeSelectAuditData();
        return ResponseEntity.ok(auditDataList);
    }
}