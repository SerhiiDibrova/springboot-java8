package com.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "warehouse_report")
public class WarehouseReportModel {
    
    @Id
    private Long id;
    private String reportName;
    private String reportDate;
    private String warehouseLocation;
    private Integer totalItems;
    private Double totalValue;
}