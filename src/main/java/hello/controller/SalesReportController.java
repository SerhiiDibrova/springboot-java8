package hello.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import hello.service.SalesReportService;

@RestController
@RequestMapping("/sales-report")
public class SalesReportController {

    private final SalesReportService salesReportService;

    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping
    public ResponseEntity<Void> insertSalesReport(@RequestBody SalesReportRequest request) {
        try {
            salesReportService.insertSalesReportData(request);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}

class SalesReportRequest {
    private String reportId;
    private String salesData;
    private String reportDate;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getSalesData() {
        return salesData;
    }

    public void setSalesData(String salesData) {
        this.salesData = salesData;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }
}