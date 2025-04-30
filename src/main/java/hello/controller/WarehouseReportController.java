package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import hello.service.WarehouseReportService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@RestController
@RequestMapping("/api")
public class WarehouseReportController {

    @Autowired
    private WarehouseReportService warehouseReportService;

    @PostMapping("/warehouse-report")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> generateWarehouseReport() {
        try {
            warehouseReportService.generateWarehouseReport();
            return ResponseEntity.ok("Warehouse report generated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating warehouse report: " + e.getMessage());
        }
    }
}

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
    }
}