package hello.controller;

import hello.service.SalesReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/sales-report")
public class SalesReportController {

    private final SalesReportService salesReportService;
    private static final Logger logger = LoggerFactory.getLogger(SalesReportController.class);

    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping("/populate")
    public ResponseEntity<String> populateSalesReport() {
        String responseMessage = salesReportService.populateSalesReport();
        return ResponseEntity.ok(responseMessage);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("Error populating sales report", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error populating sales report");
    }
}