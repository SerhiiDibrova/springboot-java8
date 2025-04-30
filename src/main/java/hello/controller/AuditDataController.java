package hello.controller;

import hello.entity.AuditData;
import hello.service.AuditDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/audit-data")
public class AuditDataController {

    @Autowired
    private AuditDataService auditDataService;

    @PostMapping("/insert-audit-data")
    public ResponseEntity<List<AuditData>> insertAuditData(@RequestParam Long managerId) {
        List<AuditData> auditDataList = auditDataService.insertAuditData(managerId);
        return ResponseEntity.ok(auditDataList);
    }

    @PostMapping("/setup")
    public ResponseEntity<Void> setupAuditDataTable() {
        auditDataService.setupAuditDataTable();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/insert")
    public ResponseEntity<Void> insertAuditDataIntoTemporaryTable(@RequestBody AuditData auditData) {
        auditDataService.insertAuditData(auditData);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<AuditData>> retrieveAuditData() {
        List<AuditData> auditDataList = auditDataService.executeSelectAuditData();
        return ResponseEntity.ok(auditDataList);
    }

    @DeleteMapping("/cleanup")
    public ResponseEntity<Void> cleanupAuditDataTable() {
        auditDataService.cleanupAuditDataTable();
        return ResponseEntity.ok().build();
    }
}