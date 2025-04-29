package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.SalesReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/sales-report")
public class SalesReportController {

    private static final Logger logger = LoggerFactory.getLogger(SalesReportController.class);

    @Autowired
    private SalesReportService salesReportService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/populate")
    public ResponseEntity<String> populateSalesReport() {
        try {
            salesReportService.populateSalesReport();
            return ResponseEntity.ok("Sales report populated successfully.");
        } catch (Exception e) {
            logger.error("Error populating sales report", e);
            return ResponseEntity.status(500).body("Error populating sales report: " + e.getMessage());
        }
    }
}