package hello.controller;

import hello.service.SalesReportService;
import hello.service.ErrorHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/sales-report")
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @Autowired
    private ErrorHandlingService errorHandlingService;

    @PostMapping("/populate")
    @Transactional
    public ResponseEntity<String> populateSalesReport(
            @RequestParam @Valid Integer orderId,
            @RequestParam(required = false) Integer managerId,
            @RequestParam @Valid String xmlData,
            @RequestParam(defaultValue = "false") Boolean isAuditNeeded) {
        try {
            salesReportService.populateSalesReport(orderId, managerId, xmlData, isAuditNeeded);
            return ResponseEntity.ok("Sales report populated successfully.");
        } catch (IllegalArgumentException e) {
            errorHandlingService.logError(e);
            return ResponseEntity.badRequest().body("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            errorHandlingService.logError(e);
            return ResponseEntity.status(500).body("Error populating sales report: " + e.getMessage());
        }
    }
}