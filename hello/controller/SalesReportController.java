package hello.controller;

import hello.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/salesreport")
@Validated
public class SalesReportController {

    private final SalesReportService salesReportService;
    private static final Logger logger = LoggerFactory.getLogger(SalesReportController.class);

    @Autowired
    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping
    public ResponseEntity<String> generateSalesReport(
            @RequestParam @NotBlank String orderId,
            @RequestParam @NotBlank String managerId,
            @RequestParam @NotBlank String xmlData,
            @RequestParam boolean isAuditNeeded) {
        try {
            salesReportService.createSalesReport(orderId, managerId, xmlData, isAuditNeeded);
            return ResponseEntity.ok("Sales report generated successfully for Order ID: " + orderId);
        } catch (IllegalArgumentException e) {
            logger.error("Invalid input: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error generating sales report: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error generating sales report: " + e.getMessage());
        }
    }
}