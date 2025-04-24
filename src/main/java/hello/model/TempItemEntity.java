

package hello.model;

import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;

public class TempItemEntity {
    private Long orderId;
    private String customerSegment;
    private String regionName;
    private String productCategory;
    private BigDecimal salesAmount;
    private BigDecimal taxRate;
    private Integer stockLevel;
    private BigDecimal shippingCost;
    private Integer warehouseCapacity;
    private Integer employeePerformance;
    private BigDecimal logisticsEfficiency;
    private BigDecimal supplierRating;
    private BigDecimal itSecurityRating;
    private BigDecimal refundAmount;
    private BigDecimal qualityAssuranceScore;
    private BigDecimal promotionDiscount;
    private BigDecimal financialStabilityIndex;
    private String riskCategory;
    private BigDecimal ecoSustainabilityIndex;

    public TempItemEntity() {}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
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

    public BigDecimal getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(BigDecimal logisticsEfficiency) {
        this.logisticsEfficiency = logisticsEfficiency;
    }

    public BigDecimal getSupplierRating() {
        return supplierRating;
    }

    public void setSupplierRating(BigDecimal supplierRating) {
        this.supplierRating = supplierRating;
    }

    public BigDecimal getItSecurityRating() {
        return itSecurityRating;
    }

    public void setItSecurityRating(BigDecimal itSecurityRating) {
        this.itSecurityRating = itSecurityRating;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getQualityAssuranceScore() {
        return qualityAssuranceScore;
    }

    public void setQualityAssuranceScore(BigDecimal qualityAssuranceScore) {
        this.qualityAssuranceScore = qualityAssuranceScore;
    }

    public BigDecimal getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(BigDecimal promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public BigDecimal getFinancialStabilityIndex() {
        return financialStabilityIndex;
    }

    public void setFinancialStabilityIndex(BigDecimal financialStabilityIndex) {
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

    @Override
    public String toString() {
        return "TempItemEntity{" +
                "orderId=" + orderId +
                ", customerSegment='" + customerSegment + '\'' +
                ", regionName='" + regionName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", salesAmount=" + salesAmount +
                ", taxRate=" + taxRate +
                ", stockLevel=" + stockLevel +
                ", shippingCost=" + shippingCost +
                ", warehouseCapacity=" + warehouseCapacity +
                ", employeePerformance=" + employeePerformance +
                ", logisticsEfficiency=" + logisticsEfficiency +
                ", supplierRating=" + supplierRating +
                ", itSecurityRating=" + itSecurityRating +
                ", refundAmount=" + refundAmount +
                ", qualityAssuranceScore=" + qualityAssuranceScore +
                ", promotionDiscount=" + promotionDiscount +
                ", financialStabilityIndex=" + financialStabilityIndex +
                ", riskCategory='" + riskCategory + '\'' +
                ", ecoSustainabilityIndex=" + ecoSustainabilityIndex +
                '}';
    }
}