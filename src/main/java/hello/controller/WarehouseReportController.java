package hello.controller;

import hello.service.WarehouseReportService;
import hello.dto.WarehouseReportDTO;
import hello.service.ErrorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;

@RestController
@ControllerAdvice
public class WarehouseReportController {

    private final WarehouseReportService warehouseReportService;
    private final ErrorLogService errorLogService;

    @Autowired
    public WarehouseReportController(WarehouseReportService warehouseReportService, ErrorLogService errorLogService) {
        this.warehouseReportService = warehouseReportService;
        this.errorLogService = errorLogService;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/warehouse-report")
    public ResponseEntity<Void> createWarehouseReport(@RequestBody WarehouseReportDTO warehouseReportDTO) {
        try {
            warehouseReportService.populateWarehouseReport(
                warehouseReportDTO.getOrderId(),
                warehouseReportDTO.getRegionName(),
                warehouseReportDTO.getProductCategory(),
                warehouseReportDTO.getStockLevel(),
                warehouseReportDTO.getLogisticsEfficiency()
            );
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            errorLogService.logError(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleException(Exception e) {
        errorLogService.logError(e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}