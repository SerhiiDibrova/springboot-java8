package hello.controller;

import hello.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/api/sales-report/generate")
    public ResponseEntity<String> generateReport(
            @RequestParam Integer orderId,
            @RequestParam(required = false) Integer managerId,
            @RequestParam String xmlData,
            @RequestParam(defaultValue = "false") Boolean isAuditNeeded) {
        
        if (orderId == null) {
            return ResponseEntity.badRequest().body("Order ID is required.");
        }
        if (xmlData == null) {
            return ResponseEntity.badRequest().body("XML data is required.");
        }
        if (managerId != null && managerId <= 0) {
            return ResponseEntity.badRequest().body("Manager ID must be a positive integer.");
        }
        
        try {
            salesReportService.generateSalesReport(orderId, managerId, xmlData, isAuditNeeded);
            return ResponseEntity.ok("Sales report generated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating sales report: " + e.getMessage());
        }
    }
}