package hello.controller;

import hello.service.AuditService;
import hello.model.AuditData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @PostMapping("/setup")
    public ResponseEntity<Void> setupAuditData() {
        try {
            auditService.setupAuditDataTable();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> insertAuditData(@RequestParam Integer managerId, @RequestBody @Valid List<AuditData> auditDataList) {
        if (managerId == null || auditDataList == null || auditDataList.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            auditService.insertAuditData(managerId, auditDataList);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/data")
    public ResponseEntity<List<AuditData>> getAuditData() {
        List<AuditData> results = auditService.executeSelectAuditData();
        if (results.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(results);
    }

    @DeleteMapping("/cleanup")
    public ResponseEntity<Void> cleanupAuditData() {
        try {
            auditService.cleanupAuditDataTable();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}