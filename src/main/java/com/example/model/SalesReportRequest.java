package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesReportRequest {
    private int orderId;
    private Integer managerId;
    private String xmlData;
    private boolean isAuditNeeded;
}