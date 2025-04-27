package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hello.service.AuditDataService;
import hello.dto.AuditDataDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditDataController {

    @Autowired
    private AuditDataService auditDataService;

    @PostMapping
    public ResponseEntity<String> insertAuditRecord(@Valid @RequestBody AuditDataDTO auditDataDTO) {
        boolean success = auditDataService.insertAuditRecord(auditDataDTO);
        if (success) {
            return ResponseEntity.ok("Audit record inserted successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to insert audit record.");
        }
    }

    @GetMapping
    public ResponseEntity<List<AuditDataDTO>> getAllAuditRecords() {
        List<AuditDataDTO> auditRecords = auditDataService.getAllAuditRecords();
        return ResponseEntity.ok(auditRecords);
    }
}