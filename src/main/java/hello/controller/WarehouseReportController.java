package hello.controller;

import hello.service.WarehouseReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/warehouse-report")
public class WarehouseReportController {

    private final WarehouseReportService warehouseReportService;

    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_REPORT_GENERATOR')")
    public ResponseEntity<Void> createWarehouseReport() {
        warehouseReportService.populateWarehouseReport();
        return ResponseEntity.ok().build();
    }
}

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Void> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}