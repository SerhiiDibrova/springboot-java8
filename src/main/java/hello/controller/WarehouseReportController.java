package hello.controller;

import hello.service.WarehouseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class WarehouseReportController {

    private final WarehouseReportService warehouseReportService;
    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportController.class);

    @Autowired
    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @PostMapping("/warehouse-report")
    public ResponseEntity<String> postWarehouseReport(@RequestBody String reportData) {
        if (reportData == null || reportData.isEmpty()) {
            return ResponseEntity.badRequest().body("Report data is required.");
        }
        try {
            String result = warehouseReportService.insertWarehouseReport(reportData);
            logger.info("Warehouse report inserted: {}", result);
            return ResponseEntity.ok("Warehouse report inserted successfully: " + result);
        } catch (Exception e) {
            logger.error("Error inserting warehouse report", e);
            return ResponseEntity.status(500).body("Error inserting warehouse report: " + e.getMessage());
        }
    }
}