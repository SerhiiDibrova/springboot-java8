package hello.controller;

import hello.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales-report")
public class SalesReportController {

    private final SalesReportService salesReportService;

    @Autowired
    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertSalesReport(@RequestBody SalesReportRequest request) {
        try {
            salesReportService.insertSalesReport(request);
            return ResponseEntity.ok("Sales report inserted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error inserting sales report: " + e.getMessage());
        }
    }
}

class SalesReportRequest {
    // Define fields for sales report data
}