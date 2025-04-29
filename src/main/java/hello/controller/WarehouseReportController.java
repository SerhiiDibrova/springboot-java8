package hello.controller;

import hello.service.WarehouseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class WarehouseReportController {

    private static final Logger logger = LoggerFactory.getLogger(WarehouseReportController.class);

    @Autowired
    private WarehouseReportService warehouseReportService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/warehouse-report/populate")
    public ResponseEntity<String> populateWarehouseReport() {
        try {
            warehouseReportService.populateWarehouseReport();
            return ResponseEntity.ok("Warehouse report populated successfully.");
        } catch (Exception e) {
            logger.error("Error populating warehouse report", e);
            return ResponseEntity.status(500).body("Failed to populate warehouse report: " + e.getMessage());
        }
    }
}

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
    }
}