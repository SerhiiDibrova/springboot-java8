package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class TempItemDTO {
    
    @NotNull
    private Integer orderId;

    @Size(max = 50)
    private String customerSegment;

    @Size(max = 50)
    private String regionName;

    @Size(max = 50)
    private String productCategory;

    @NotNull
    private BigDecimal salesAmount;

    private BigDecimal taxRate = BigDecimal.ZERO;

    private Integer stockLevel = 0;

    private BigDecimal shippingCost = BigDecimal.ZERO;

    private Integer warehouseCapacity = 0;

    private Integer employeePerformance = 0;

    private Integer logisticsEfficiency = 0;

    private Integer supplierRating = 0;

    private Integer itSecurityRating = 0;

    private BigDecimal refundAmount = BigDecimal.ZERO;

    private Integer qualityAssuranceScore = 0;

    private BigDecimal promotionDiscount = BigDecimal.ZERO;

    private Integer financialStabilityIndex = 0;

    @Size(max = 50)
    private String riskCategory;

    private BigDecimal ecoSustainabilityIndex = BigDecimal.ZERO;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Integer getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(Integer warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public Integer getEmployeePerformance() {
        return employeePerformance;
    }

    public void setEmployeePerformance(Integer employeePerformance) {
        this.employeePerformance = employeePerformance;
    }

    public Integer getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(Integer logisticsEfficiency) {
        this.logisticsEfficiency = logisticsEfficiency;
    }

    public Integer getSupplierRating() {
        return supplierRating;
    }

    public void setSupplierRating(Integer supplierRating) {
        this.supplierRating = supplierRating;
    }

    public Integer getItSecurityRating() {
        return itSecurityRating;
    }

    public void setItSecurityRating(Integer itSecurityRating) {
        this.itSecurityRating = itSecurityRating;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getQualityAssuranceScore() {
        return qualityAssuranceScore;
    }

    public void setQualityAssuranceScore(Integer qualityAssuranceScore) {
        this.qualityAssuranceScore = qualityAssuranceScore;
    }

    public BigDecimal getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(BigDecimal promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public Integer getFinancialStabilityIndex() {
        return financialStabilityIndex;
    }

    public void setFinancialStabilityIndex(Integer financialStabilityIndex) {
        this.financialStabilityIndex = financialStabilityIndex;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public BigDecimal getEcoSustainabilityIndex() {
        return ecoSustainabilityIndex;
    }

    public void setEcoSustainabilityIndex(BigDecimal ecoSustainabilityIndex) {
        this.ecoSustainabilityIndex = ecoSustainabilityIndex;
    }
}