package hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.List;
import hello.service.AuditDataService;
import hello.dto.AuditDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/audit-data")
public class AuditDataController {

    @Autowired
    private AuditDataService auditDataService;

    @PostMapping
    public ResponseEntity<List<AuditDataDTO>> insertAuditData(@RequestBody Integer managerId) {
        if (managerId == null || managerId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        try {
            List<AuditDataDTO> auditData = auditDataService.insertAuditData(managerId);
            return ResponseEntity.ok(auditData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AuditDataDTO>> getAuditData(@RequestBody Integer managerId) {
        if (managerId == null || managerId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        List<AuditDataDTO> auditData = null;
        try {
            auditDataService.setupAuditDataTable();
            auditDataService.insertAuditData(managerId);
            auditData = auditDataService.executeSelectAuditData();
            auditDataService.handleQueryResults(auditData);
            return ResponseEntity.ok(auditData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } finally {
            auditDataService.cleanupAuditDataTable();
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void handleException(Exception e) {
    }
}