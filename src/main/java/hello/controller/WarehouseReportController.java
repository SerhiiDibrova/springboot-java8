package hello.controller;

import hello.service.WarehouseReportService;
import hello.dto.WarehouseReportDTO;
import hello.service.ErrorLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseReportController {
    private final WarehouseReportService warehouseReportService;
    private final ErrorLogService errorLogService;

    public WarehouseReportController(WarehouseReportService warehouseReportService, ErrorLogService errorLogService) {
        this.warehouseReportService = warehouseReportService;
        this.errorLogService = errorLogService;
    }

    @PostMapping("/warehouse-report")
    public ResponseEntity<String> insertWarehouseReport(@RequestBody WarehouseReportDTO warehouseReportDTO) {
        try {
            warehouseReportService.populateWarehouseReport(warehouseReportDTO);
            return ResponseEntity.ok("Warehouse report populated successfully.");
        } catch (IllegalArgumentException e) {
            errorLogService.logError("Invalid input: " + e.getMessage(), 1, 0);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            errorLogService.logError("Error processing request: " + e.getMessage(), 1, 0);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error populating warehouse report: " + e.getMessage());
        }
    }
}