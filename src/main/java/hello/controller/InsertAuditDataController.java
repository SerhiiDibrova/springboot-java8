package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import hello.model.AuditData;
import hello.service.InsertAuditDataService;

@RestController
public class InsertAuditDataController {

    @Autowired
    private InsertAuditDataService insertAuditDataService;

    @GetMapping("/audit-data")
    public ResponseEntity<List<AuditData>> getAuditData(@RequestParam String managerId) {
        try {
            List<AuditData> auditDataList = insertAuditDataService.getAuditDataByManagerId(managerId);
            return ResponseEntity.ok(auditDataList);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}