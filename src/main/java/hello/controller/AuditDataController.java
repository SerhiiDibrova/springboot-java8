package hello.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import hello.service.AuditDataService;
import hello.model.AuditData;
import java.util.List;

@RestController
@RequestMapping("/audit-data")
public class AuditDataController {

    private final AuditDataService auditDataService;

    public AuditDataController(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;
    }

    @PostMapping
    public ResponseEntity<Void> insertAuditRecord(@RequestParam(required = true) Integer managerId) {
        if (managerId == null || managerId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        try {
            auditDataService.insertAuditData(managerId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AuditData>> getAuditData() {
        List<AuditData> auditDataList;
        try {
            auditDataList = auditDataService.getAuditData();
            return ResponseEntity.ok(auditDataList);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}