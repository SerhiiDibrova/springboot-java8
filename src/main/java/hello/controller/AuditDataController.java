package hello.controller;

import hello.service.AuditDataService;
import hello.exception.ControllerAdvice;
import hello.model.AuditData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/audit-data")
public class AuditDataController {

    @Autowired
    private AuditDataService auditDataService;

    @PostMapping("/setup")
    public ResponseEntity<Void> setupAuditDataTable() {
        auditDataService.setupAuditDataTable();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/insert")
    public ResponseEntity<List<AuditData>> insertAuditData(@RequestParam @NotNull Long managerId) {
        List<AuditData> insertedData = auditDataService.insertAuditData(managerId);
        return ResponseEntity.status(201).body(insertedData);
    }

    @GetMapping("/select")
    public ResponseEntity<List<AuditData>> selectAuditData() {
        List<AuditData> auditDataList = auditDataService.executeSelectAuditData();
        return ResponseEntity.ok(auditDataList);
    }

    @PostMapping("/cleanup")
    public ResponseEntity<Void> cleanupAuditDataTable() {
        auditDataService.cleanupAuditDataTable();
        return ResponseEntity.ok().build();
    }
}