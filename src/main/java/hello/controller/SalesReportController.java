package hello.controller;

import hello.service.SalesReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales-report")
public class SalesReportController {

    private final SalesReportService salesReportService;

    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping("/insert")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Void> createSalesReport(
            @RequestParam Integer orderId,
            @RequestParam(required = false) Integer managerId,
            @RequestParam String xmlData,
            @RequestParam(defaultValue = "false") Boolean isAuditNeeded) {
        if (orderId == null || xmlData == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            salesReportService.generateSalesReport(orderId, managerId, xmlData, isAuditNeeded);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}