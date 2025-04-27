package com.example.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "sales_report")
public class SalesReportModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "quantity_sold", nullable = false)
    private int quantitySold;

    @Column(name = "total_revenue", nullable = false)
    private double totalRevenue;

    @Column(name = "sale_date", nullable = false)
    private String saleDate;

    public SalesReportModel() {
    }

    public SalesReportModel(String productName, int quantitySold, double totalRevenue, String saleDate) {
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.totalRevenue = totalRevenue;
        this.saleDate = saleDate;
    }
}