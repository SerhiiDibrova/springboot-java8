package hello.controller;

import hello.service.SalesReportService;
import hello.dto.SalesReportRequestDTO;
import hello.service.TempItemService;
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

    @Autowired
    private TempItemService tempItemService;

    @PostMapping("/insert")
    public ResponseEntity<String> insertSalesReport(@RequestBody String xmlData) {
        try {
            if (!isValidXml(xmlData)) {
                return ResponseEntity.badRequest().body("Invalid XML data");
            }
            Integer orderId = extractOrderId(xmlData);
            tempItemService.insertTempItems(xmlData, orderId);
            salesReportService.populateSalesReport();
            logger.info("Sales report populated successfully.");
            return ResponseEntity.status(HttpStatus.CREATED).body("Sales report populated successfully");
        } catch (DataAccessException e) {
            logger.error("Data access error while populating sales report: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error populating sales report: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error while populating sales report: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error populating sales report: " + e.getMessage());
        }
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateSalesReport(@RequestBody SalesReportRequestDTO request) {
        try {
            salesReportService.generateSalesReport(request);
            logger.info("Sales report generated successfully.");
            return ResponseEntity.ok("Sales report generated successfully.");
        } catch (Exception e) {
            logger.error("Error generating sales report: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating sales report.");
        }
    }

    private boolean isValidXml(String xmlData) {
        // Implement XML validation logic
        return true;
    }

    private Integer extractOrderId(String xmlData) {
        // Implement logic to extract orderId from xmlData
        return 1; // Placeholder
    }
}