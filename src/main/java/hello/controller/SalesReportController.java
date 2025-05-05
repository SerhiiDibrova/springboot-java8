package hello.controller;

import hello.service.SalesReportService;
import hello.dto.SalesReportDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class SalesReportController {

    private static final Logger logger = LoggerFactory.getLogger(SalesReportController.class);

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/sales-report/generate")
    public ResponseEntity<?> getSalesReport(
            @RequestParam Integer orderId,
            @RequestParam(required = false) Integer managerId,
            @RequestParam String xmlData,
            @RequestParam(defaultValue = "false") Boolean isAuditNeeded) {
        
        if (orderId == null || xmlData == null) {
            logger.error("Validation failed: Order ID and XML Data are required.");
            return ResponseEntity.badRequest().body("Order ID and XML data are required.");
        }
        
        try {
            SalesReportDTO report = salesReportService.getSalesReport(orderId, managerId, xmlData, isAuditNeeded);
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            logger.error("Error generating sales report: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while generating the report.");
        }
    }
}