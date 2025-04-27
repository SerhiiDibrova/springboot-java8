package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.SalesReportService;
import javax.validation.Valid;

@RestController
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/sales-report")
    public ResponseEntity<?> insertSalesReport(@Valid SalesReportRequest request) {
        try {
            salesReportService.populateSalesReport(request);
            return ResponseEntity.ok(new ApiResponse(true, "Sales report populated successfully."));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Data integrity violation."));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "Failed to populate sales report."));
        }
    }
}

class SalesReportRequest {
    // Define fields and validation annotations
}

class ApiResponse {
    private boolean success;
    private String message;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Getters and setters
}