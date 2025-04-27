package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.SalesReportRequest;
import com.example.service.GetSalesReportService;

@RestController
@RequestMapping("/sales-report")
public class GetSalesReportController {
    @Autowired
    private GetSalesReportService salesReportService;

    @PostMapping
    public ResponseEntity<Void> generateSalesReport(@RequestBody SalesReportRequest request) {
        salesReportService.generateSalesReport(request.getOrderId(), request.getManagerId(), request.getXmlData(), request.isAuditNeeded());
        return ResponseEntity.ok().build();
    }
}