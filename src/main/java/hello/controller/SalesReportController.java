package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.service.SalesReportService;
import hello.model.SalesReport;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @GetMapping("/sales-report")
    public ResponseEntity<List<SalesReport>> getSalesReport(@RequestParam String startDate, @RequestParam String endDate) {
        validateDate(startDate);
        validateDate(endDate);
        List<SalesReport> report = salesReportService.generateReport(startDate, endDate);
        if (report.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(report);
    }

    private void validateDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            throw new InvalidDateFormatException("Invalid date format: " + date);
        }
    }

    @ExceptionHandler(InvalidDateFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleInvalidDateFormat(InvalidDateFormatException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

class InvalidDateFormatException extends RuntimeException {
    public InvalidDateFormatException(String message) {
        super(message);
    }
}