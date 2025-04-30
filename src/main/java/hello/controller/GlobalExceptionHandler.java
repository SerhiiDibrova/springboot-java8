package hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import hello.service.ErrorHandlingService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import hello.service.SalesReportService;
import hello.service.WarehouseReportService;
import hello.service.AuditDataService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final ErrorHandlingService errorHandlingService;

    public GlobalExceptionHandler(ErrorHandlingService errorHandlingService) {
        this.errorHandlingService = errorHandlingService;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        errorHandlingService.logError(ex.getMessage());
        return ResponseEntity.status(500).body("An error occurred: " + ex.getMessage());
    }
}

@RestController
@RequestMapping("/api")
class SalesReportController {

    private final SalesReportService salesReportService;

    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping("/sales-report")
    public ResponseEntity<String> populateSalesReport() {
        salesReportService.populateSalesReport();
        return ResponseEntity.ok("Sales report populated successfully.");
    }
}

@RestController
@RequestMapping("/api")
class WarehouseReportController {

    private final WarehouseReportService warehouseReportService;

    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @PostMapping("/warehouse-report")
    public ResponseEntity<String> populateWarehouseReport() {
        warehouseReportService.populateWarehouseReport();
        return ResponseEntity.ok("Warehouse report populated successfully.");
    }
}

@RestController
@RequestMapping("/api")
class AuditDataController {

    private final AuditDataService auditDataService;

    public AuditDataController(AuditDataService auditDataService) {
        this.auditDataService = auditDataService;
    }

    @PostMapping("/audit-data/setup")
    public ResponseEntity<String> setupAuditDataTable() {
        auditDataService.setupAuditDataTable();
        return ResponseEntity.ok("Audit data table setup successfully.");
    }

    @PostMapping("/audit-data/insert")
    public ResponseEntity<String> insertAuditData(@RequestBody List<AuditData> auditDataList) {
        auditDataService.insertAuditData(auditDataList);
        return ResponseEntity.ok("Audit data inserted successfully.");
    }

    @GetMapping("/audit-data/select")
    public ResponseEntity<List<AuditData>> executeSelectAuditData() {
        List<AuditData> auditData = auditDataService.executeSelectAuditData();
        return ResponseEntity.ok(auditData);
    }

    @DeleteMapping("/audit-data/cleanup")
    public ResponseEntity<String> cleanupAuditDataTable() {
        auditDataService.cleanupAuditDataTable();
        return ResponseEntity.ok("Audit data table cleaned up successfully.");
    }
}