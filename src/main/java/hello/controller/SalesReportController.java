package hello.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import hello.model.SalesReportRequest;
import hello.model.SalesReportResponse;
import hello.service.SalesReportService;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
@RequestMapping("/api/sales-report")
@Validated
public class SalesReportController {

    private final SalesReportService salesReportService;

    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping
    public ResponseEntity<SalesReportResponse> generateSalesReport(@RequestBody @Validated SalesReportRequest request) {
        try {
            SalesReportResponse response = salesReportService.generateReport(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Invalid input data");
    }
}