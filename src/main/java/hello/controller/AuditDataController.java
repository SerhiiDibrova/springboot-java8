package hello.controller;

import hello.service.AuditDataService;
import hello.model.AuditData;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditDataController {

    private final AuditDataService auditDataService;

    public AuditDataController(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;
    }

    @PostMapping("/setup")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> setupAuditData() {
        try {
            auditDataService.setupAuditDataTable();
            return ResponseEntity.ok("Audit data table setup successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error setting up audit data table.");
        }
    }

    @PostMapping("/insert")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> insertAuditData(@RequestBody List<AuditData> auditDataList) {
        if (auditDataList == null || auditDataList.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid audit data list.");
        }
        try {
            auditDataService.insertAuditData(auditDataList);
            return ResponseEntity.status(HttpStatus.CREATED).body("Audit data inserted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting audit data.");
        }
    }

    @GetMapping("/data")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<AuditData>> getAuditData() {
        try {
            List<AuditData> results = auditDataService.executeSelectAuditData();
            return ResponseEntity.ok(results);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/cleanup")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> cleanupAuditData() {
        try {
            auditDataService.cleanupAuditDataTable();
            return ResponseEntity.ok("Audit data table cleaned up successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error cleaning up audit data table.");
        }
    }
}