package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import hello.service.SalesReportService;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/reports")
public class SalesReportController {

    private final SalesReportService salesReportService;
    private static final Logger logger = LoggerFactory.getLogger(SalesReportController.class);

    @Autowired
    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping("/generate")
    public ResponseEntity<Void> generateReport(@RequestBody ReportRequest reportRequest) {
        try {
            salesReportService.generateReport(reportRequest);
            logger.info("Report generation initiated successfully for request: {}", reportRequest);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Error generating report: {}", e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
}