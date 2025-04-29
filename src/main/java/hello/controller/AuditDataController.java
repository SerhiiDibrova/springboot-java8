package hello.controller;

import hello.service.AuditDataService;
import hello.dto.AuditDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit-data")
public class AuditDataController {

    @Autowired
    private AuditDataService auditDataService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<List<AuditDataDTO>> insertAuditData(@RequestBody Integer managerId) {
        if (managerId == null || managerId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        List<AuditDataDTO> results;
        try {
            auditDataService.setupAuditDataTable();
            auditDataService.insertAuditData(managerId);
            results = auditDataService.executeSelectAuditData();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        } finally {
            auditDataService.cleanupAuditDataTable();
        }
        return ResponseEntity.ok(results);
    }
}