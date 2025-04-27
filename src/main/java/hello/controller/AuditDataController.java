package hello.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import hello.service.AuditDataService;
import hello.model.AuditDataDTO;
import java.util.List;

@RestController
@RequestMapping("/audit-data")
public class AuditDataController {

    private final AuditDataService auditDataService;

    public AuditDataController(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;
    }

    @PostMapping
    public ResponseEntity<Void> insertAuditData(@RequestParam Integer managerId, @RequestBody AuditDataDTO auditDataDTO) {
        if (managerId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        try {
            auditDataService.insertAuditData(managerId, auditDataDTO);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AuditDataDTO>> getAuditData() {
        List<AuditDataDTO> auditDataList;
        try {
            auditDataList = auditDataService.getAuditData();
            return ResponseEntity.ok(auditDataList);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}