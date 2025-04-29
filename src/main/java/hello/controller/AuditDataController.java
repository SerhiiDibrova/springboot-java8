package hello.controller;

import hello.service.AuditDataService;
import hello.dto.AuditDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditDataController {

    private final AuditDataService auditDataService;

    @Autowired
    public AuditDataController(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;
    }

    @PostMapping("/{managerId}")
    public ResponseEntity<AuditDataDTO> insertAuditData(@PathVariable Long managerId, @Valid @RequestBody AuditDataDTO auditDataDTO) {
        try {
            auditDataService.createTemporaryTable();
            AuditDataDTO createdAuditData = auditDataService.insertAuditData(managerId, auditDataDTO);
            return ResponseEntity.ok(createdAuditData);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{managerId}")
    public ResponseEntity<List<AuditDataDTO>> getAuditData(@PathVariable Long managerId) {
        try {
            List<AuditDataDTO> auditDataList = auditDataService.getAuditData(managerId);
            return ResponseEntity.ok(auditDataList);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{managerId}")
    public ResponseEntity<Void> cleanupAuditData(@PathVariable Long managerId) {
        try {
            auditDataService.cleanupAuditData(managerId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}