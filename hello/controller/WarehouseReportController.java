package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.WarehouseReportService;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/warehouse-report")
public class WarehouseReportController {

    private final WarehouseReportService warehouseReportService;

    @Autowired
    public WarehouseReportController(WarehouseReportService warehouseReportService) {
        this.warehouseReportService = warehouseReportService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateReport(@Valid @RequestBody ReportRequest reportRequest) {
        try {
            warehouseReportService.populateWarehouseReport(reportRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("Report generated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating report: " + e.getMessage());
        }
    }
}

class ReportRequest {
    // Define fields and validation annotations as needed
}