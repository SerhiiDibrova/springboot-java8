package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import hello.model.GetSalesReportRequestDTO;
import hello.service.GetSalesReportService;

@RestController
@RequestMapping("/sales-report")
public class GetSalesReportController {
    private final GetSalesReportService getSalesReportService;
    private static final Logger logger = LoggerFactory.getLogger(GetSalesReportController.class);

    public GetSalesReportController(GetSalesReportService getSalesReportService) {
        this.getSalesReportService = getSalesReportService;
    }

    @PostMapping
    public ResponseEntity<String> generateSalesReport(@RequestBody GetSalesReportRequestDTO requestDTO) {
        try {
            getSalesReportService.getSalesReport(requestDTO);
            return ResponseEntity.ok("Sales report generated successfully");
        } catch (IllegalArgumentException e) {
            logger.error("Invalid input for sales report generation: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error generating sales report", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating sales report: " + e.getMessage());
        }
    }
}