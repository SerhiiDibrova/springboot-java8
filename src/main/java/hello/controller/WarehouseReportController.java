package hello.controller;

import hello.service.WarehouseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/warehouse-report")
public class WarehouseReportController {

    @Autowired
    private WarehouseReportService warehouseReportService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/populate")
    public ResponseEntity<String> populateWarehouseReport() {
        try {
            warehouseReportService.populateWarehouseReport();
            return ResponseEntity.ok("Warehouse report populated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error populating warehouse report: " + e.getMessage());
        }
    }
}