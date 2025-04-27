package hello.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import hello.service.AuditDataService;

@RestController
@RequestMapping("/audit-data")
public class AuditDataController {

    @Autowired
    private AuditDataService auditDataService;

    @PostMapping
    public ResponseEntity<String> insertAuditRecord(@RequestBody AuditDataDTO auditDataDTO) {
        String managerId = auditDataDTO.getManagerId();
        boolean success = auditDataService.insertAuditRecord(managerId);
        if (success) {
            return ResponseEntity.ok("Audit record inserted successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to insert audit record.");
        }
    }
}