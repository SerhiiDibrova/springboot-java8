package hello.controller;

import hello.service.AuditDataService;
import hello.model.AuditData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditDataController {

    @Autowired
    private AuditDataService auditDataService;

    @PostMapping("/audit-data/setup")
    public ResponseEntity<Void> setupAuditDataTable() {
        auditDataService.setupAuditDataTable();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/audit-data/insert")
    public ResponseEntity<String> insertAuditData(@RequestBody(required = false) List<AuditData> auditDataList, @RequestParam(required = false) Long managerId) {
        if (auditDataList == null || auditDataList.isEmpty()) {
            return ResponseEntity.badRequest().body("Audit data list cannot be empty or null.");
        }
        auditDataService.insertAuditData(auditDataList, managerId);
        return ResponseEntity.ok("Audit data inserted successfully.");
    }

    @GetMapping("/audit-data/select")
    public ResponseEntity<List<AuditData>> executeSelectAuditData() {
        List<AuditData> auditData = auditDataService.executeSelectAuditData();
        return ResponseEntity.ok(auditData);
    }

    @DeleteMapping("/audit-data/cleanup")
    public ResponseEntity<Void> cleanupAuditDataTable() {
        auditDataService.cleanupAuditDataTable();
        return ResponseEntity.ok().build();
    }
}