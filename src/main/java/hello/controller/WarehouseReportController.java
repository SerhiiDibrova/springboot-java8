package hello.controller;

import hello.service.WarehouseReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouse/report")
public class WarehouseReportController {

    private final WarehouseReportService warehouseReportService;
    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportController.class);

    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @PostMapping("/populate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> populateWarehouseReport() {
        try {
            warehouseReportService.populateWarehouseReport();
            return ResponseEntity.ok("Warehouse report populated successfully.");
        } catch (Exception ex) {
            logger.error("Error populating warehouse report", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error populating warehouse report: " + ex.getMessage());
        }
    }
}