package hello.controller;

import hello.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales-report")
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateSalesReport(
            @RequestParam Integer orderId,
            @RequestParam(required = false) Integer managerId,
            @RequestParam String xmlData,
            @RequestParam(defaultValue = "false") Boolean isAuditNeeded) {
        if (orderId == null || xmlData == null || xmlData.isEmpty()) {
            return ResponseEntity.badRequest().body("orderId and xmlData are required.");
        }
        try {
            salesReportService.getSalesReport(orderId, managerId, xmlData, isAuditNeeded);
            return ResponseEntity.ok("Sales report generated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating sales report: " + e.getMessage());
        }
    }
}