package hello.controller;

import hello.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales-report")
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/generate")
    public ResponseEntity<Void> createSalesReport(
            @RequestParam Integer orderId,
            @RequestParam(required = false) Integer managerId,
            @RequestParam String xmlData,
            @RequestParam(defaultValue = "0") Integer isAuditNeeded) {
        salesReportService.populateSalesReport(orderId, managerId, xmlData, isAuditNeeded);
        return ResponseEntity.ok().build();
    }
}