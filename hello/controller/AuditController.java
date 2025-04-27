package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.AuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/audit")
public class AuditController {

    private static final Logger logger = LoggerFactory.getLogger(AuditController.class);

    @Autowired
    private AuditService auditService;

    @PostMapping("/createTempAuditTable")
    public ResponseEntity<String> createTempAuditTable() {
        try {
            auditService.createTempAuditTable();
            logger.info("Temporary audit table created successfully.");
            return ResponseEntity.status(HttpStatus.CREATED).body("Temporary audit table created.");
        } catch (Exception e) {
            logger.error("Error creating temporary audit table: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating temporary audit table.");
        }
    }

    @PostMapping("/insertAuditData")
    public ResponseEntity<String> insertAuditData(@RequestBody String auditData) {
        if (auditData == null || auditData.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid audit data.");
        }
        try {
            auditService.insertAuditData(auditData);
            logger.info("Audit data inserted successfully.");
            return ResponseEntity.status(HttpStatus.OK).body("Audit data inserted.");
        } catch (Exception e) {
            logger.error("Error inserting audit data: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting audit data.");
        }
    }

    @PostMapping("/cleanupAuditTable")
    public ResponseEntity<String> cleanupAuditTable() {
        try {
            auditService.cleanupAuditTable();
            logger.info("Audit table cleaned up successfully.");
            return ResponseEntity.status(HttpStatus.OK).body("Audit table cleaned up.");
        } catch (Exception e) {
            logger.error("Error cleaning up audit table: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error cleaning up audit table.");
        }
    }
}