package hello.controller;

import hello.service.AuditDataService;
import hello.model.AuditData;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/audit-data")
public class AuditDataController {

    private final AuditDataService auditDataService;

    public AuditDataController(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> insertAuditData(
            @RequestParam Integer managerId,
            @RequestParam String auditId,
            @RequestParam String recordDetails) {
        if (managerId == null || managerId < 0 || auditId == null || auditId.isEmpty() || recordDetails == null || recordDetails.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid input");
        }
        try {
            auditDataService.insertAuditData(managerId, auditId, recordDetails);
            return ResponseEntity.ok("Audit data inserted successfully");
        } catch (Exception e) {
            // Log the exception here for better traceability
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting audit data");
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<AuditData>> getAllAuditData() {
        try {
            List<AuditData> auditDataList = auditDataService.getAllAuditData();
            return ResponseEntity.ok(auditDataList);
        } catch (Exception e) {
            // Log the exception here for better traceability
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving audit data");
        }
    }
}