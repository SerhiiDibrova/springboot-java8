package hello.controller;

import hello.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales-report")
public class SalesReportController {

    private final SalesReportService salesReportService;

    @Autowired
    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateSalesReport(
            @RequestParam String orderId,
            @RequestParam String managerId,
            @RequestParam String xmlData,
            @RequestParam boolean isAuditNeeded) {
        try {
            salesReportService.generateReport(orderId, managerId, xmlData, isAuditNeeded);
            return ResponseEntity.ok("Sales report generated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error generating sales report: " + e.getMessage());
        }
    }
}