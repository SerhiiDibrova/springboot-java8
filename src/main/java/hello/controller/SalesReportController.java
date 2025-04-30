package hello.controller;

import hello.service.SalesReportService;
import hello.declaration.GlobalExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/sales-report")
@Validated
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping
    public ResponseEntity<Void> generateSalesReport(
            @RequestParam @NotNull Integer orderId,
            @RequestParam(required = false) Integer managerId,
            @RequestParam @NotNull String xmlData,
            @RequestParam(defaultValue = "false") Boolean isAuditNeeded) {
        try {
            salesReportService.generateSalesReport(orderId, managerId, xmlData, isAuditNeeded);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new GlobalExceptionHandler(e);
        }
    }
}