package hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @GetMapping("/audit-data/{managerId}")
    public ResponseEntity<List<AuditDataDTO>> getAuditData(@PathVariable Integer managerId) {
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

    @GetMapping("/audit/retrieve")
    public ResponseEntity<List<AuditDataDTO>> retrieveAuditData() {
        List<AuditDataDTO> auditData = auditService.retrieveAuditData();
        return ResponseEntity.ok(auditData);
    }

    @PostMapping("/audit/cleanup")
    public void cleanupAuditTable() {
        auditService.cleanupAuditTable();
    }
}