package hello.controller;

import hello.service.WarehouseReportService;
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

    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @PostMapping("/generate")
    @PreAuthorize("hasAuthority('GENERATE_REPORT')")
    public ResponseEntity<String> generateReport() {
        try {
            warehouseReportService.generateWarehouseReport();
            return ResponseEntity.ok("Warehouse report generated successfully.");
        } catch (SpecificException1 e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Specific error occurred: " + e.getMessage());
        } catch (SpecificException2 e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Another specific error occurred: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating warehouse report: " + e.getMessage());
        }
    }
}