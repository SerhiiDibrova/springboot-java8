package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import hello.service.AuditService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AuditController {

    private static final Logger logger = LoggerFactory.getLogger(AuditController.class);

    @Autowired
    private AuditService auditService;

    @GetMapping("/audit/{managerId}")
    public ResponseEntity<Object> getAuditData(@PathVariable String managerId) {
        if (managerId == null || managerId.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid managerId");
        }
        try {
            Object auditData = auditService.retrieveAuditData(managerId);
            return ResponseEntity.ok(auditData);
        } catch (Exception e) {
            logger.error("Error retrieving audit data for managerId: {}", managerId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving audit data");
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("An error occurred: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }
}