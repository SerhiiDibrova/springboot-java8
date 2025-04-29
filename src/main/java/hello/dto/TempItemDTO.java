package hello.dto;

import java.math.BigDecimal;

public class TempItemDTO {
    private String orderId;
    private String customerSegment;
    private String regionName;
    private BigDecimal financialMetric1;
    private BigDecimal financialMetric2;
    private BigDecimal financialMetric3;
    private BigDecimal financialMetric4;
    private BigDecimal financialMetric5;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or empty");
        }
        this.orderId = orderId;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        if (customerSegment == null || customerSegment.isEmpty()) {
            throw new IllegalArgumentException("Customer Segment cannot be null or empty");
        }
        this.customerSegment = customerSegment;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        if (regionName == null || regionName.isEmpty()) {
            throw new IllegalArgumentException("Region Name cannot be null or empty");
        }
        this.regionName = regionName;
    }

    public BigDecimal getFinancialMetric1() {
        return financialMetric1;
    }

    public void setFinancialMetric1(BigDecimal financialMetric1) {
        validateFinancialMetric(financialMetric1);
        this.financialMetric1 = financialMetric1;
    }

    public BigDecimal getFinancialMetric2() {
        return financialMetric2;
    }

    public void setFinancialMetric2(BigDecimal financialMetric2) {
        validateFinancialMetric(financialMetric2);
        this.financialMetric2 = financialMetric2;
    }

    public BigDecimal getFinancialMetric3() {
        return financialMetric3;
    }

    public void setFinancialMetric3(BigDecimal financialMetric3) {
        validateFinancialMetric(financialMetric3);
        this.financialMetric3 = financialMetric3;
    }

    public BigDecimal getFinancialMetric4() {
        return financialMetric4;
    }

    public void setFinancialMetric4(BigDecimal financialMetric4) {
        validateFinancialMetric(financialMetric4);
        this.financialMetric4 = financialMetric4;
    }

    public BigDecimal getFinancialMetric5() {
        return financialMetric5;
    }

    public void setFinancialMetric5(BigDecimal financialMetric5) {
        validateFinancialMetric(financialMetric5);
        this.financialMetric5 = financialMetric5;
    }

    private void validateFinancialMetric(BigDecimal metric) {
        if (metric == null || metric.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Financial metrics must be non-null and non-negative");
        }
    }
}