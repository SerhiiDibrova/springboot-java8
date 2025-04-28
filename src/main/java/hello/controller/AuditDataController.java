package hello.controller;

import hello.service.AuditDataService;
import hello.model.AuditData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuditDataController {

    private final AuditDataService auditDataService;

    @Autowired
    public AuditDataController(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;
    }

    @GetMapping("/api/audit-data/{managerId}")
    public ResponseEntity<List<AuditData>> getAuditData(@PathVariable Integer managerId) {
        try {
            List<AuditData> auditData = auditDataService.getAuditDataByManagerId(managerId);
            return ResponseEntity.ok(auditData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}