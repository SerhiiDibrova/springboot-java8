package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hello.service.AuditDataService;
import hello.dto.AuditDataDTO;

import java.util.List;

@RestController
@RequestMapping("/audit-data")
public class AuditDataController {

    @Autowired
    private AuditDataService auditDataService;

    @PostMapping
    public ResponseEntity<List<AuditDataDTO>> insertAuditData(@RequestParam Long managerId, @RequestBody List<AuditDataDTO> auditDataList) {
        if (managerId == null || auditDataList == null || auditDataList.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            List<AuditDataDTO> insertedData = auditDataService.insertAuditData(managerId, auditDataList);
            return ResponseEntity.ok(insertedData);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AuditDataDTO>> getAuditData(@RequestParam Long managerId) {
        if (managerId == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            List<AuditDataDTO> auditData = auditDataService.getAuditData(managerId);
            return ResponseEntity.ok(auditData);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}