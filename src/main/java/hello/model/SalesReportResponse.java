package hello.model;

import java.util.List;

public class SalesReportResponse {
    private List<String> salesData;
    private double totalRevenue;
    private int totalUnitsSold;
    private String reportDate;
    private String reportGeneratedBy;

    public SalesReportResponse(List<String> salesData, double totalRevenue, int totalUnitsSold, String reportDate, String reportGeneratedBy) {
        this.salesData = salesData;
        this.totalRevenue = totalRevenue;
        this.totalUnitsSold = totalUnitsSold;
        this.reportDate = reportDate;
        this.reportGeneratedBy = reportGeneratedBy;
    }

    public List<String> getSalesData() {
        return salesData;
    }

    public void setSalesData(List<String> salesData) {
        this.salesData = salesData;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public int getTotalUnitsSold() {
        return totalUnitsSold;
    }

    public void setTotalUnitsSold(int totalUnitsSold) {
        this.totalUnitsSold = totalUnitsSold;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportGeneratedBy() {
        return reportGeneratedBy;
    }

    public void setReportGeneratedBy(String reportGeneratedBy) {
        this.reportGeneratedBy = reportGeneratedBy;
    }
}