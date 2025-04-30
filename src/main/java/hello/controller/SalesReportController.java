package hello.controller;

import hello.service.SalesReportService;
import hello.dto.SalesReportDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<String> postSalesReport(@Valid @RequestBody SalesReportDTO salesReportDTO) {
        try {
            salesReportService.generateSalesReport(salesReportDTO.getOrderId(), salesReportDTO.getManagerId(), salesReportDTO.getXmlData(), salesReportDTO.isAuditNeeded());
            return ResponseEntity.ok("Sales report generated successfully.");
        } catch (Exception e) {
            logger.error("Error generating sales report: {}", e.getMessage());
            return ResponseEntity.status(500).body("Failed to generate sales report: " + e.getMessage());
        }
    }
}