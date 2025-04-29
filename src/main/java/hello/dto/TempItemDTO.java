package hello.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public class TempItemDTO {

    @NotNull
    @JsonProperty("orderId")
    private Integer orderId;

    @NotNull
    @Size(max = 50)
    @JsonProperty("customerSegment")
    private String customerSegment;

    @NotNull
    @Size(max = 50)
    @JsonProperty("regionName")
    private String regionName;

    @NotNull
    @Size(max = 50)
    @JsonProperty("productCategory")
    private String productCategory;

    @NotNull
    @JsonProperty("salesAmount")
    private BigDecimal salesAmount;

    @NotNull
    @JsonProperty("taxRate")
    private BigDecimal taxRate;

    @NotNull
    @JsonProperty("stockLevel")
    private Integer stockLevel;

    @NotNull
    @JsonProperty("shippingCost")
    private BigDecimal shippingCost;

    @NotNull
    @JsonProperty("warehouseCapacity")
    private Integer warehouseCapacity;

    @NotNull
    @JsonProperty("employeePerformance")
    private BigDecimal employeePerformance;

    @NotNull
    @JsonProperty("logisticsEfficiency")
    private BigDecimal logisticsEfficiency;

    @NotNull
    @JsonProperty("supplierRating")
    private BigDecimal supplierRating;

    @NotNull
    @JsonProperty("itSecurityRating")
    private BigDecimal itSecurityRating;

    @NotNull
    @JsonProperty("refundAmount")
    private BigDecimal refundAmount;

    @NotNull
    @JsonProperty("qualityAssuranceScore")
    private BigDecimal qualityAssuranceScore;

    @NotNull
    @JsonProperty("promotionDiscount")
    private BigDecimal promotionDiscount;

    @NotNull
    @JsonProperty("financialStabilityIndex")
    private BigDecimal financialStabilityIndex;

    @NotNull
    @Size(max = 50)
    @JsonProperty("riskCategory")
    private String riskCategory;

    @NotNull
    @JsonProperty("ecoSustainabilityIndex")
    private BigDecimal ecoSustainabilityIndex;

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

    public BigDecimal getEmployeePerformance() {
        return employeePerformance;
    }

    public void setEmployeePerformance(BigDecimal employeePerformance) {
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
}