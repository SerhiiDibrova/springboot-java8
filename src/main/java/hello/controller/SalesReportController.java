package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.SalesReportService;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/sales-report")
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateReport(@RequestBody @Validated SalesReportRequest request) {
        try {
            boolean success = salesReportService.generateReport(request.getOrderId(), request.getManagerId(), request.getXmlData(), request.isAuditRequired());
            return success ? ResponseEntity.ok("Report generated successfully") : ResponseEntity.status(500).body("Failed to generate report: Please check the input parameters and try again.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while generating the report: " + e.getMessage());
        }
    }
}

class SalesReportRequest {
    @NotBlank
    private String orderId;
    
    @NotBlank
    private String managerId;
    
    @NotBlank
    private String xmlData;
    
    private boolean auditRequired;

    public SalesReportRequest(String orderId, String managerId, String xmlData, boolean auditRequired) {
        this.orderId = orderId;
        this.managerId = managerId;
        this.xmlData = xmlData;
        this.auditRequired = auditRequired;
    }

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

    public boolean isAuditRequired() {
        return auditRequired;
    }

    public void setAuditRequired(boolean auditRequired) {
        this.auditRequired = auditRequired;
    }
}