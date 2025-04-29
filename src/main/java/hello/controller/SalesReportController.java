package hello.controller;

import hello.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class SalesReportController {

    private final SalesReportService salesReportService;
    private static final Logger logger = LoggerFactory.getLogger(SalesReportController.class);

    @Autowired
    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @Async
    @PostMapping("/sales-report")
    public ResponseEntity<Void> createSalesReport() {
        try {
            salesReportService.populateSalesReport();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Error populating sales report", e);
            return ResponseEntity.status(500).build();
        }
    }
}