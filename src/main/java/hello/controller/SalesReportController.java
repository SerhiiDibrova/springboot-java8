package hello.controller;

import hello.service.SalesReportService;
import hello.dto.SalesReportDTO;
import hello.exception.DataInsertionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/sales-report")
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/populate")
    public ResponseEntity<Void> populateSalesReport(@RequestBody @Valid SalesReportDTO salesReportDTO) {
        try {
            salesReportService.populateSalesReport(salesReportDTO);
            return ResponseEntity.ok().build();
        } catch (DataInsertionException e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}