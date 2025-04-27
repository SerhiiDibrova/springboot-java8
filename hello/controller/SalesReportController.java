package hello.controller;

import hello.dto.SalesReportRequest;
import hello.service.SalesReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales-report")
public class SalesReportController {

    private final SalesReportService salesReportService;

    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping
    public ResponseEntity<String> generateSalesReport(@RequestBody SalesReportRequest request) {
        if (request == null || !isValidRequest(request)) {
            return ResponseEntity.badRequest().body("Invalid request");
        }
        try {
            salesReportService.generateReport(request);
            return ResponseEntity.ok("Sales report generated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating sales report: " + e.getMessage());
        }
    }

    private boolean isValidRequest(SalesReportRequest request) {
        // Add validation logic for SalesReportRequest
        return true; // Placeholder for actual validation
    }
}