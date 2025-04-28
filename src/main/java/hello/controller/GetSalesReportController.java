package hello.controller;

import hello.service.GetSalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetSalesReportController {

    @Autowired
    private GetSalesReportService getSalesReportService;

    @PostMapping("/sales-report")
    public ResponseEntity<Void> insertSalesReport(
            @RequestParam Integer orderId,
            @RequestParam(required = false) Integer managerId,
            @RequestParam String xmlData,
            @RequestParam(defaultValue = "false") Boolean isAuditNeeded) {
        if (orderId == null || xmlData == null) {
            return ResponseEntity.badRequest().build();
        }
        try {
            getSalesReportService.generateSalesReport(orderId, managerId, xmlData, isAuditNeeded);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}