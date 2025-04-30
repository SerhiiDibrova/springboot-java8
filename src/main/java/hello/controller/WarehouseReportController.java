package hello.controller;

import hello.service.WarehouseReportService;
import hello.service.ErrorHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseReportController {

    @Autowired
    private WarehouseReportService warehouseReportService;

    @Autowired
    private ErrorHandlingService errorHandlingService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/warehouse-report/populate")
    public ResponseEntity<String> populateWarehouseReport() {
        try {
            warehouseReportService.populateWarehouseReport();
            return ResponseEntity.ok("Warehouse report populated successfully.");
        } catch (SpecificExceptionType e) {
            errorHandlingService.logError(e);
            return ResponseEntity.status(400).body("Specific error occurred while populating warehouse report.");
        } catch (Exception e) {
            errorHandlingService.logError(e);
            return ResponseEntity.status(500).body("Error populating warehouse report.");
        }
    }
}