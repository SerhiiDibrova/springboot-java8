package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.SalesReportService;

@RestController
@RequestMapping("/api/sales-report")
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateReport(@RequestBody SalesReportRequest request) {
        boolean success = salesReportService.generateReport(request.getOrderId(), request.getManagerId(), request.getXmlData(), request.isAuditNeeded());
        return success ? ResponseEntity.ok("Report generated successfully") : ResponseEntity.status(500).body("Failed to generate report");
    }
}

class SalesReportRequest {
    private String orderId;
    private String managerId;
    private String xmlData;
    private boolean isAuditNeeded;

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getXmlData() {
        return xmlData;
    }

    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }

    public boolean isAuditNeeded() {
        return isAuditNeeded;
    }

    public void setAuditNeeded(boolean auditNeeded) {
        isAuditNeeded = auditNeeded;
    }
}