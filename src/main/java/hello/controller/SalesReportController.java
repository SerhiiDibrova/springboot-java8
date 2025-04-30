package hello.controller;

import hello.service.SalesReportService;
import hello.controller.GlobalExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@ControllerAdvice
public class SalesReportController {

    private final SalesReportService salesReportService;

    public SalesReportController(SalesReportService salesReportService) {
        this.salesReportService = salesReportService;
    }

    @PostMapping("/sales-report")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> createSalesReport(@Valid @RequestBody SalesReportRequest request) {
        try {
            salesReportService.populateSalesReport(request.getOrderId(), request.getManagerId(), request.getXmlData(), request.getIsAuditNeeded());
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }
}

class SalesReportRequest {
    @NotNull
    private Integer orderId;
    private Integer managerId;
    @NotNull
    private String xmlData;
    private Boolean isAuditNeeded = false;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getXmlData() {
        return xmlData;
    }

    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }

    public Boolean getIsAuditNeeded() {
        return isAuditNeeded;
    }

    public void setIsAuditNeeded(Boolean isAuditNeeded) {
        this.isAuditNeeded = isAuditNeeded;
    }
}