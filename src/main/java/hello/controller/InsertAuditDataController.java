package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import hello.model.AuditData;
import hello.service.InsertAuditDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class InsertAuditDataController {

    @Autowired
    private InsertAuditDataService insertAuditDataService;

    private static final Logger logger = LoggerFactory.getLogger(InsertAuditDataController.class);

    @GetMapping("/audit-data")
    public ResponseEntity<List<AuditData>> getAuditData(@RequestParam String managerId) {
        try {
            List<AuditData> auditDataList = insertAuditDataService.getAuditDataByManagerId(managerId);
            if (auditDataList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(auditDataList);
        } catch (Exception e) {
            logger.error("Error retrieving audit data for managerId: {}", managerId, e);
            return ResponseEntity.status(500).body(null);
        }
    }
}