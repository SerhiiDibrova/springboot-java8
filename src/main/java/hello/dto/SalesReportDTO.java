package hello.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class SalesReportDTO {
    @NotNull
    @Size(min = 1, max = 50)
    private String reportId;

    @NotNull
    @Size(min = 1, max = 100)
    private String productName;

    @NotNull
    @Positive
    private int quantitySold;

    @NotNull
    @Positive
    private double totalRevenue;

    @NotNull
    @Size(min = 10, max = 10)
    private String salesDate;

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
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

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }
}