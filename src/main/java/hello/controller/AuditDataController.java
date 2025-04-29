package hello.controller;

import hello.service.AuditDataService;
import hello.dto.AuditDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit-data")
public class AuditDataController {

    private final AuditDataService auditDataService;

    @Autowired
    public AuditDataController(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;
    }

    @PostMapping
    public ResponseEntity<List<AuditDataDTO>> insertAuditData(@RequestParam Long managerId) {
        List<AuditDataDTO> auditData = auditDataService.insertAuditData(managerId);
        return ResponseEntity.ok(auditData);
    }

    @PostMapping("/setup")
    public ResponseEntity<Void> setupTemporaryTable() {
        auditDataService.setupTemporaryTable();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/records")
    public ResponseEntity<List<AuditDataDTO>> retrieveRecords() {
        List<AuditDataDTO> records = auditDataService.retrieveRecords();
        return ResponseEntity.ok(records);
    }

    @DeleteMapping("/cleanup")
    public ResponseEntity<Void> cleanupTable() {
        auditDataService.cleanupTable();
        return ResponseEntity.ok().build();
    }
}