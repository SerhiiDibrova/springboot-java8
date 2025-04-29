package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SalesReport")
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Sales_Status", nullable = false)
    private String salesStatus;

    @Column(name = "Discount_Status", nullable = false)
    private String discountStatus;

    @Column(name = "Performance_Status", nullable = false)
    private String performanceStatus;

    @Column(name = "StockLevel", nullable = false)
    private Integer stockLevel;

    @Column(name = "TotalSales", nullable = false)
    private BigDecimal totalSales;

    @Column(name = "ReportDate", nullable = false)
    private Date reportDate;

    @PostLoad
    public void deriveStatuses() {
        if (stockLevel == 0) {
            salesStatus = "Out of Stock";
        } else {
            salesStatus = "In Stock";
        }
        discountStatus = totalSales.compareTo(BigDecimal.ZERO) > 0 ? "Discount Applied" : "No Discount";
        performanceStatus = totalSales.compareTo(new BigDecimal("1000")) > 0 ? "High Performance" : "Low Performance";
    }

    @PrePersist
    @PreUpdate
    public void validate() {
        if (totalSales == null || totalSales.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("TotalSales must be non-negative");
        }
        if (stockLevel == null) {
            throw new IllegalArgumentException("StockLevel must not be null");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public String getDiscountStatus() {
        return discountStatus;
    }

    public void setDiscountStatus(String discountStatus) {
        this.discountStatus = discountStatus;
    }

    public String getPerformanceStatus() {
        return performanceStatus;
    }

    public void setPerformanceStatus(String performanceStatus) {
        this.performanceStatus = performanceStatus;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
}