

package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.service.WarehouseReportService;

@RestController
public class WarehouseReportController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseReportController.class);

    @Autowired
    private WarehouseReportService warehouseReportService;

    @GetMapping("/warehouse-report")
    public ResponseEntity<?> getWarehouseReport() {
        try {
            Object reportData = warehouseReportService.getWarehouseReportData();
            if (reportData == null) {
                LOGGER.error("Warehouse report data is null");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving warehouse report data");
            }
            return ResponseEntity.ok(reportData);
        } catch (Exception e) {
            LOGGER.error("Error retrieving warehouse report data", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving warehouse report data");
        }
    }
}