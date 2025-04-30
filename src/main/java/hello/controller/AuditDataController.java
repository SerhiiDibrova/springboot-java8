package hello.controller;

import hello.entity.AuditData;
import hello.service.AuditDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuditDataController {

    @Autowired
    private AuditDataService auditDataService;

    @PostMapping("/audit-data")
    public ResponseEntity<List<AuditData>> insertAuditData(@RequestParam Integer managerId) {
        try {
            auditDataService.setupAuditDataTable();
            auditDataService.insertAuditData(managerId);
            List<AuditData> auditDataList = auditDataService.executeSelectAuditData();
            auditDataService.handleQueryResults(auditDataList);
            return ResponseEntity.ok(auditDataList);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        } finally {
            auditDataService.cleanupAuditDataTable();
        }
    }
}