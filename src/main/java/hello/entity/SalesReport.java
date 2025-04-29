package hello.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SalesReport {
    private String productId;
    private String productName;
    private int quantitySold;
    private BigDecimal totalRevenue;
    private LocalDate reportDate;

    public SalesReport(String productId, String productName, int quantitySold, BigDecimal totalRevenue, LocalDate reportDate) {
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Product Name cannot be null or empty");
        }
        if (quantitySold < 0) {
            throw new IllegalArgumentException("Quantity Sold cannot be negative");
        }
        if (totalRevenue == null || totalRevenue.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Total Revenue cannot be null or negative");
        }
        if (reportDate == null) {
            throw new IllegalArgumentException("Report Date cannot be null");
        }
        this.productId = productId;
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.totalRevenue = totalRevenue;
        this.reportDate = reportDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public static List<SalesReport> generateReports(List<SalesData> salesDataList) {
        List<SalesReport> reports = new ArrayList<>();
        for (SalesData data : salesDataList) {
            SalesReport report = new SalesReport(data.getProductId(), data.getProductName(), data.getQuantitySold(), data.getTotalRevenue(), data.getReportDate());
            reports.add(report);
        }
        return reports;
    }
}

class SalesData {
    private String productId;
    private String productName;
    private int quantitySold;
    private BigDecimal totalRevenue;
    private LocalDate reportDate;

    public SalesData(String productId, String productName, int quantitySold, BigDecimal totalRevenue, LocalDate reportDate) {
        this.productId = productId;
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.totalRevenue = totalRevenue;
        this.reportDate = reportDate;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }
}