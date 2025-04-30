package hello.controller;

import hello.service.AuditDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

@RestController
@ControllerAdvice
public class AuditDataController {

    @Autowired
    private AuditDataService auditDataService;

    @PostMapping("/audit-data/insert")
    public ResponseEntity<String> insertAuditData(@RequestParam Long managerId) {
        try {
            auditDataService.insertAuditData(managerId);
            return ResponseEntity.ok("Audit data inserted successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Manager ID not found: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting audit data: " + e.getMessage());
        }
    }

    @PostMapping("/audit-data")
    public ResponseEntity<String> processAuditData(@RequestParam Long managerId) {
        try {
            auditDataService.setupAuditDataTable();
            auditDataService.insertAuditData(managerId);
            auditDataService.executeSelectAuditData();
            auditDataService.cleanupAuditDataTable();
            return ResponseEntity.ok("Audit data processed successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Manager ID not found: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing audit data: " + e.getMessage());
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
    }
}