package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.service.SalesReportService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @GetMapping("/sales-report")
    public ResponseEntity<String> getSalesReport(@RequestParam String startDate, @RequestParam String endDate) {
        if (startDate == null || startDate.isEmpty() || endDate == null || endDate.isEmpty()) {
            return ResponseEntity.badRequest().body("Start date and end date must not be null or empty.");
        }
        
        LocalDate start;
        LocalDate end;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        try {
            start = LocalDate.parse(startDate, formatter);
            end = LocalDate.parse(endDate, formatter);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format. Please use ISO format (yyyy-MM-dd).");
        }

        return ResponseEntity.ok(salesReportService.generateReport(start, end));
    }
}