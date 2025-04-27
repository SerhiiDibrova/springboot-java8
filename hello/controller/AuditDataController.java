package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditDataController {

    @Autowired
    private AuditDataService auditDataService;

    @PostMapping
    public ResponseEntity<Void> insertAuditData(@RequestBody AuditData auditData) {
        auditDataService.insertAuditData(auditData);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<AuditData>> getAuditRecords() {
        List<AuditData> auditRecords = auditDataService.getAuditRecords();
        return ResponseEntity.ok(auditRecords);
    }
}