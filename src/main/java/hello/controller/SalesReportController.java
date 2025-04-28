package hello.controller;

import hello.service.SalesReportService;
import hello.dto.SalesReportDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales-report")
@Validated
public class SalesReportController {
    private static final Logger logger = LoggerFactory.getLogger(SalesReportController.class);

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/insert")
    public ResponseEntity<Void> insertSalesReport(@RequestBody SalesReportDTO salesReportDTO) {
        try {
            salesReportService.populateSalesReport(salesReportDTO);
            logger.info("Sales report inserted successfully.");
            return ResponseEntity.ok().build();
        } catch (DataAccessException e) {
            logger.error("Data access error while inserting sales report: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            logger.error("Error while inserting sales report: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}