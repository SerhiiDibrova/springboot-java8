package hello.controller;

import hello.service.SalesReportService;
import hello.dto.SalesReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sales-report")
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @GetMapping
    public ResponseEntity<List<SalesReportDTO>> getSalesReport(
            @RequestParam(required = false) @Valid String startDate,
            @RequestParam(required = false) @Valid String endDate,
            @RequestParam(required = false) String customerSegment) {
        if (startDate == null || endDate == null) {
            return ResponseEntity.badRequest().build();
        }
        List<SalesReportDTO> report = salesReportService.generateSalesReport(startDate, endDate, customerSegment);
        return ResponseEntity.ok(report);
    }

    @PostMapping("/api/sales-report/generate")
    public ResponseEntity<String> generateReport() {
        try {
            salesReportService.generateSalesReport();
            return ResponseEntity.ok("Sales report generated successfully.");
        } catch (Exception e) {
            throw e;
        }
    }

    @GetMapping("/generate")
    public ResponseEntity<String> generateReportGet() {
        try {
            salesReportService.generateSalesReport();
            return ResponseEntity.ok("Sales report generated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating sales report: " + e.getMessage());
        }
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateReport(@RequestParam Integer orderId, 
                                                 @RequestParam(required = false) Integer managerId, 
                                                 @RequestParam String xmlData, 
                                                 @RequestParam(defaultValue = "false") Boolean isAuditNeeded) {
        if (orderId == null || xmlData == null) {
            return ResponseEntity.badRequest().body("Order ID and XML data are required.");
        }
        try {
            salesReportService.generateSalesReport(orderId, managerId, xmlData, isAuditNeeded);
            return ResponseEntity.ok("Sales report generated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while generating the report.");
        }
    }
}