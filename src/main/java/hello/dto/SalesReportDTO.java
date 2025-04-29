package hello.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesReportDTO {
    private String productName;
    private int quantitySold;
    private BigDecimal totalRevenue;
    private LocalDate reportDate;

    public SalesReportDTO(String productName, int quantitySold, BigDecimal totalRevenue, LocalDate reportDate) {
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.totalRevenue = totalRevenue;
        this.reportDate = reportDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public String toSymbolicString() {
        return String.format("Product: %s | Quantity Sold: %d | Total Revenue: %s | Report Date: %s", 
                             productName, quantitySold, totalRevenue.toString(), reportDate.toString());
    }
}