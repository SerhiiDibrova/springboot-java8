package hello.model;

import java.math.BigDecimal;

public class SalesDataResponse {
    private String orderId;
    private BigDecimal totalSalesAmount;
    private BigDecimal applicableDiscounts;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(BigDecimal totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    public BigDecimal getApplicableDiscounts() {
        return applicableDiscounts;
    }

    public void setApplicableDiscounts(BigDecimal applicableDiscounts) {
        this.applicableDiscounts = applicableDiscounts;
    }
}