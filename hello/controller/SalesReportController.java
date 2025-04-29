package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import hello.service.SalesReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

@RestController
@Validated
public class SalesReportController {

    private static final Logger logger = LoggerFactory.getLogger(SalesReportController.class);

    @Autowired
    private SalesReportService salesReportService;

    @PostMapping("/sales-report")
    public ResponseEntity<String> generateSalesReport(@Valid @RequestBody SalesReportRequest request) {
        try {
            salesReportService.getSalesReport(request.getOrderId(), request.getManagerId(), request.getXmlData(), request.isAuditNeeded());
            logger.info("Sales report generated successfully for orderId: {}", request.getOrderId());
            return ResponseEntity.ok("Sales report generated successfully.");
        } catch (Exception e) {
            logger.error("Error generating sales report for orderId: {}", request.getOrderId(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating sales report.");
        }
    }
}

class SalesReportRequest {
    @javax.validation.constraints.NotNull
    private String orderId;
    
    @javax.validation.constraints.NotNull
    private String managerId;
    
    private String xmlData;
    
    private boolean isAuditNeeded;

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