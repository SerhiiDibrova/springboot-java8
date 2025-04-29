package hello.controller;

import hello.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.annotation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Validated
public class SalesReportController {

    private static final Logger logger = LoggerFactory.getLogger(SalesReportController.class);

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/sales-report/populate")
    public ResponseEntity<String> populateSalesReport() {
        logger.info("Request to populate sales report received.");
        try {
            salesReportService.populateSalesReport();
            logger.info("Sales report populated successfully.");
            return ResponseEntity.ok("Sales report populated successfully.");
        } catch (Exception e) {
            logger.error("Error populating sales report: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error populating sales report: " + e.getMessage());
        }
    }
}