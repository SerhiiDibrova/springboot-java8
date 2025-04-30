package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
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

    @NotNull
    private BigDecimal taxRate;

    @NotNull
    private Integer stockLevel;

    @NotNull
    private BigDecimal shippingCost;

    @NotNull
    private Integer warehouseCapacity;

    @NotNull
    private Integer employeePerformance;

    @NotNull
    private BigDecimal logisticsEfficiency;

    @NotNull
    private BigDecimal supplierRating;

    @NotNull
    private BigDecimal itSecurityRating;

    @NotNull
    private BigDecimal refundAmount;

    @NotNull
    private BigDecimal qualityAssuranceScore;

    @NotNull
    private BigDecimal promotionDiscount;

    @NotNull
    private BigDecimal financialStabilityIndex;

    @Size(max = 50)
    private String riskCategory;

    @NotNull
    private BigDecimal ecoSustainabilityIndex;

    @JsonProperty("orderId")
    @XmlElement
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @JsonProperty("customerSegment")
    @XmlElement
    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    @JsonProperty("regionName")
    @XmlElement
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @JsonProperty("productCategory")
    @XmlElement
    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @JsonProperty("salesAmount")
    @XmlElement
    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }

    @JsonProperty("taxRate")
    @XmlElement
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @JsonProperty("stockLevel")
    @XmlElement
    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    @JsonProperty("shippingCost")
    @XmlElement
    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    @JsonProperty("warehouseCapacity")
    @XmlElement
    public Integer getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(Integer warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    @JsonProperty("employeePerformance")
    @XmlElement
    public Integer getEmployeePerformance() {
        return employeePerformance;
    }

    public void setEmployeePerformance(Integer employeePerformance) {
        this.employeePerformance = employeePerformance;
    }

    @JsonProperty("logisticsEfficiency")
    @XmlElement
    public BigDecimal getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(BigDecimal logisticsEfficiency) {
        this.logisticsEfficiency = logisticsEfficiency;
    }

    @JsonProperty("supplierRating")
    @XmlElement
    public BigDecimal getSupplierRating() {
        return supplierRating;
    }

    public void setSupplierRating(BigDecimal supplierRating) {
        this.supplierRating = supplierRating;
    }

    @JsonProperty("itSecurityRating")
    @XmlElement
    public BigDecimal getItSecurityRating() {
        return itSecurityRating;
    }

    public void setItSecurityRating(BigDecimal itSecurityRating) {
        this.itSecurityRating = itSecurityRating;
    }

    @JsonProperty("refundAmount")
    @XmlElement
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    @JsonProperty("qualityAssuranceScore")
    @XmlElement
    public BigDecimal getQualityAssuranceScore() {
        return qualityAssuranceScore;
    }

    public void setQualityAssuranceScore(BigDecimal qualityAssuranceScore) {
        this.qualityAssuranceScore = qualityAssuranceScore;
    }

    @JsonProperty("promotionDiscount")
    @XmlElement
    public BigDecimal getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(BigDecimal promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    @JsonProperty("financialStabilityIndex")
    @XmlElement
    public BigDecimal getFinancialStabilityIndex() {
        return financialStabilityIndex;
    }

    public void setFinancialStabilityIndex(BigDecimal financialStabilityIndex) {
        this.financialStabilityIndex = financialStabilityIndex;
    }

    @JsonProperty("riskCategory")
    @XmlElement
    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    @JsonProperty("ecoSustainabilityIndex")
    @XmlElement
    public BigDecimal getEcoSustainabilityIndex() {
        return ecoSustainabilityIndex;
    }

    public void setEcoSustainabilityIndex(BigDecimal ecoSustainabilityIndex) {
        this.ecoSustainabilityIndex = ecoSustainabilityIndex;
    }
}