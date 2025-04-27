package hello.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import hello.service.SalesReportService;
import hello.model.SalesReportDTO;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/sales-report")
public class SalesReportController {

    private final SalesReportService salesReportService;
    private static final Logger logger = LoggerFactory.getLogger(SalesReportController.class);

    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping
    public ResponseEntity<Void> insertSalesReport(@Valid @RequestBody SalesReportRequest request) {
        try {
            salesReportService.insertSalesReportData(request);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            logger.error("Validation error: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            logger.error("Error inserting sales report: {}", e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
}

class SalesReportRequest {
    @javax.validation.constraints.NotNull
    private String reportId;

    @javax.validation.constraints.NotNull
    private String salesData;

    @javax.validation.constraints.NotNull
    @javax.validation.constraints.Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
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