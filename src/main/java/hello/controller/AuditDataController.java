package hello.controller;

import hello.service.AuditDataService;
import hello.dto.AuditDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditdata")
public class AuditDataController {

    private final AuditDataService auditDataService;

    @Autowired
    public AuditDataController(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;
    }

    @PostMapping
    public ResponseEntity<List<AuditDataDTO>> insertAuditData(@RequestParam String managerId, @RequestParam(required = false) String filter) {
        try {
            auditDataService.createTemporaryTable();
            List<AuditDataDTO> auditDataList = auditDataService.insertAuditData(managerId, filter);
            return ResponseEntity.ok(auditDataList);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        } finally {
            auditDataService.cleanupTemporaryTable();
        }
    }
}