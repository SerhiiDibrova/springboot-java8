package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import hello.service.SalesReportService;
import hello.model.SalesReportRequest;
import javax.validation.Valid;

@RestController
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/sales-report")
    public ResponseEntity<Void> insertSalesReport(@Valid @RequestBody SalesReportRequest request) {
        try {
            salesReportService.insertSalesReport(request);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}