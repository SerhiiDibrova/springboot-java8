package hello.controller;

import hello.service.SalesReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales-report")
public class SalesReportController {

    private final SalesReportService salesReportService;

    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping("/populate")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> populateSalesReport(
            @RequestParam Integer orderId,
            @RequestParam(required = false) Integer managerId,
            @RequestParam String xmlData,
            @RequestParam(defaultValue = "false") Boolean isAuditNeeded) {
        
        try {
            String result = salesReportService.populateSalesReport(orderId, managerId, xmlData, isAuditNeeded);
            return ResponseEntity.ok("Sales report populated successfully: " + result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Order ID and XML data are required.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}