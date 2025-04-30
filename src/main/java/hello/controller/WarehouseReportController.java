package hello.controller;

import hello.service.WarehouseReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WarehouseReportController {

    private final WarehouseReportService warehouseReportService;

    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @PostMapping("/warehouse-report")
    @Transactional
    public ResponseEntity<String> populateWarehouseReport() {
        try {
            warehouseReportService.populateWarehouseReport();
            return ResponseEntity.ok("Warehouse report populated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error populating warehouse report: " + e.getMessage());
        }
    }
}