package hello.controller;

import hello.service.SalesReportService;
import hello.dto.SalesReportDTO;
import hello.request.SalesReportRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class SalesReportController {

    private static final Logger logger = LoggerFactory.getLogger(SalesReportController.class);

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/sales-report")
    public ResponseEntity<SalesReportDTO> generateSalesReport(@Valid @RequestBody SalesReportRequest request) {
        if (request.getOrderId() == null || request.getXmlData() == null) {
            logger.error("Validation failed: Order ID and XML Data are mandatory fields.");
            return ResponseEntity.badRequest().body(null);
        }
        try {
            SalesReportDTO report = salesReportService.getSalesReport(
                request.getOrderId(),
                request.getManagerId() != null ? request.getManagerId() : null,
                request.getXmlData(),
                request.getIsAuditNeeded() != null ? request.getIsAuditNeeded() : false
            );
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            logger.error("Error generating sales report: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}