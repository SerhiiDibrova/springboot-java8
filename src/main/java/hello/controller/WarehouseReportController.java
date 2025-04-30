package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.WarehouseReportService;
import hello.exception.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/warehouse-report")
public class WarehouseReportController {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportController.class);

    @Autowired
    private WarehouseReportService warehouseReportService;

    @PostMapping
    public ResponseEntity<String> postWarehouseReport(@RequestBody ReportRequest request) {
        try {
            validateRequest(request);
            warehouseReportService.generateWarehouseReport(request);
            logger.info("Warehouse report generated successfully.");
            return ResponseEntity.ok("Warehouse report has been generated successfully.");
        } catch (Exception e) {
            logger.error("Error generating warehouse report: {}", e.getMessage());
            throw new GlobalExceptionHandler.CustomException("Failed to generate warehouse report", e);
        }
    }

    private void validateRequest(ReportRequest request) {
        // Add validation logic for request data
    }
}