package hello.dto;

import java.time.LocalDate;

public class SalesReportRequest {
    private String productId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String region;

    public SalesReportRequest(String productId, LocalDate startDate, LocalDate endDate, String region) {
        setProductId(productId);
        setStartDate(startDate);
        setEndDate(endDate);
        setRegion(region);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
        this.productId = productId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if (startDate == null || startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date cannot be null and must be before the end date");
        }
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (endDate == null || endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date cannot be null and must be after the start date");
        }
        this.endDate = endDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        if (region == null || region.isEmpty()) {
            throw new IllegalArgumentException("Region cannot be null or empty");
        }
        this.region = region;
    }
    
    public void generateReport() {
        // Implementation for generating the sales report
    }
}