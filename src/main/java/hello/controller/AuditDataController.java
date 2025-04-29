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

    @Autowired
    private AuditDataService auditDataService;

    @GetMapping("/{managerId}")
    public ResponseEntity<List<AuditDataDTO>> getAuditData(@PathVariable Integer managerId) {
        List<AuditDataDTO> auditData = auditDataService.getAuditData(managerId);
        if (auditData.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(auditData);
    }

    @PostMapping
    public ResponseEntity<List<AuditDataDTO>> insertAuditData(@RequestParam Integer managerId) {
        try {
            List<AuditDataDTO> auditData = auditDataService.insertAuditData(managerId);
            return ResponseEntity.ok(auditData);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AuditDataDTO>> setupAuditData() {
        auditDataService.setupAuditDataTable();
        List<AuditDataDTO> auditData = auditDataService.insertAuditData();
        if (auditData.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        auditDataService.executeSelectAuditData();
        auditDataService.cleanupAuditDataTable();
        return ResponseEntity.ok(auditData);
    }
}