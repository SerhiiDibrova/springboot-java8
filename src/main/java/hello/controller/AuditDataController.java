package hello.controller;

import hello.dto.AuditDataDTO;
import hello.service.AuditDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/audit-data")
public class AuditDataController {

    private final AuditDataService auditDataService;

    public AuditDataController(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;
    }

    @PostMapping("/setup")
    public ResponseEntity<Void> setupAuditDataTable() {
        try {
            auditDataService.setupAuditDataTable();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Void> insertAuditData(@RequestBody AuditDataDTO auditData) {
        try {
            auditDataService.insertAuditData(auditData);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<List<AuditDataDTO>> postAuditData(@RequestParam Integer managerId) {
        if (managerId == null) {
            return ResponseEntity.badRequest().body(null);
        }
        try {
            List<AuditDataDTO> auditDataList = auditDataService.insertAuditData(managerId);
            return ResponseEntity.ok(auditDataList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/select")
    public ResponseEntity<List<AuditDataDTO>> executeSelectAuditData() {
        try {
            List<AuditDataDTO> results = auditDataService.executeSelectAuditData();
            if (!results.isEmpty()) {
                return ResponseEntity.ok(results);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/cleanup")
    public ResponseEntity<Void> cleanupAuditDataTable() {
        try {
            auditDataService.cleanupAuditDataTable();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}