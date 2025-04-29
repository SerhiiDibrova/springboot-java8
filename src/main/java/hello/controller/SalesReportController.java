package hello.controller;

import hello.dto.SalesReportDTO;
import hello.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Validated
public class SalesReportController {

    private final SalesReportService salesReportService;
    private static final Logger logger = LoggerFactory.getLogger(SalesReportController.class);

    @Autowired
    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping("/salesreport")
    public ResponseEntity<String> createSalesReport(@RequestBody @Validated SalesReportDTO salesReportDTO) {
        try {
            salesReportService.insertSalesReport(salesReportDTO);
            return new ResponseEntity<>("Sales report inserted successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            logger.error("Validation error: {}", e.getMessage());
            return new ResponseEntity<>("Validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Failed to insert sales report: {}", e.getMessage());
            return new ResponseEntity<>("Failed to insert sales report", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}