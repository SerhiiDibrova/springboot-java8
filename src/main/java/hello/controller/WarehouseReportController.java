package hello.controller;

import hello.service.WarehouseReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseReportController {

    private final WarehouseReportService warehouseReportService;

    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @PostMapping("/generateWarehouseReport")
    public ResponseEntity<String> generateWarehouseReport() {
        try {
            warehouseReportService.generateWarehouseReport();
            return ResponseEntity.ok("Warehouse report generated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating warehouse report: " + e.getMessage());
        }
    }
}