package hello.controller;

import hello.service.WarehouseReportService;
import hello.dto.WarehouseReportDTO;
import hello.service.ErrorLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class WarehouseReportController {
    private final WarehouseReportService warehouseReportService;

    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @PostMapping("/warehouse-report")
    public ResponseEntity<Void> insertWarehouseReport(@RequestBody WarehouseReportDTO warehouseReportDTO) {
        try {
            warehouseReportService.populateWarehouseReport(warehouseReportDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException e) {
            ErrorLogService.logError("Invalid input: " + e.getMessage(), 1, 0);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            ErrorLogService.logError("Error processing request: " + e.getMessage(), 1, 0);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}