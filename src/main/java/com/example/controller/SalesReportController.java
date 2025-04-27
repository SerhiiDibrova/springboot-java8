package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.service.SalesReportService;

@RestController
@RequestMapping("/api/sales-report")
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateSalesReport(
            @RequestParam String orderId,
            @RequestParam String managerId,
            @RequestParam String xmlData,
            @RequestParam boolean isAuditNeeded) {
        return salesReportService.generateReport(orderId, managerId, xmlData, isAuditNeeded);
    }
}