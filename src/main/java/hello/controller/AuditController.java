package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.service.AuditService;
import hello.dto.AuditDataDTO;
import java.util.List;

@RestController
public class AuditController {

    private final AuditService auditService;

    @Autowired
    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/audit")
    public ResponseEntity<List<AuditDataDTO>> getAuditData(@RequestParam Integer managerId) {
        List<AuditDataDTO> auditData = auditService.retrieveAuditData(managerId);
        return ResponseEntity.ok(auditData);
    }

    @PostMapping("/audit/create")
    public void createTempAuditTable() {
        auditService.createTempAuditTable();
    }

    @PostMapping("/audit/insert")
    public void insertAuditRecord(@RequestParam String action, @RequestParam String timestamp, @RequestParam String userId, @RequestParam String details) {
        if (action == null || timestamp == null || userId == null || details == null) {
            throw new IllegalArgumentException("All parameters must be provided");
        }
        auditService.insertAuditRecord(action, timestamp, userId, details);
    }

    @PostMapping("/audit/cleanup")
    public void cleanupAuditTable() {
        auditService.cleanupAuditTable();
    }
}