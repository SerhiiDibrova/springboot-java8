package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "TempItems")
public class TempItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @NotNull
    @Column(name = "configId")
    private String configId;

    @NotNull
    @Column(name = "customerSegment")
    private String customerSegment;

    @NotNull
    @Column(name = "regionName")
    private String regionName;

    @NotNull
    @Column(name = "productCategory")
    private String productCategory;

    @NotNull
    @Column(name = "salesAmount")
    private Double salesAmount;

    @NotNull
    @Column(name = "taxRate")
    private Double taxRate;

    @NotNull
    @Column(name = "stockLevel")
    private Integer stockLevel;

    @NotNull
    @Column(name = "shippingCost")
    private Double shippingCost;

    @NotNull
    @Column(name = "warehouseCapacity")
    private Integer warehouseCapacity;

    @NotNull
    @Column(name = "employeePerformance")
    private Double employeePerformance;

    @NotNull
    @Column(name = "logisticsEfficiency")
    private Double logisticsEfficiency;

    @NotNull
    @Column(name = "supplierRating")
    private Double supplierRating;

    @NotNull
    @Column(name = "itSecurityRating")
    private Double itSecurityRating;

    @NotNull
    @Column(name = "refundAmount")
    private Double refundAmount;

    @NotNull
    @Column(name = "qualityAssuranceScore")
    private Double qualityAssuranceScore;

    @NotNull
    @Column(name = "promotionDiscount")
    private Double promotionDiscount;

    @NotNull
    @Column(name = "financialStabilityIndex")
    private Double financialStabilityIndex;

    @NotNull
    @Column(name = "riskCategory")
    private String riskCategory;

    @NotNull
    @Column(name = "ecoSustainabilityIndex")
    private Double ecoSustainabilityIndex;

    @OneToMany(mappedBy = "tempItem", cascade = CascadeType.ALL)
    private List<CustomConfig> customConfigs;

    @OneToMany(mappedBy = "tempItem", cascade = CascadeType.ALL)
    private List<LegacyConfig> legacyConfigs;

    public TempItem() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
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

    public Double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Integer getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(Integer warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public Double getEmployeePerformance() {
        return employeePerformance;
    }

    public void setEmployeePerformance(Double employeePerformance) {
        this.employeePerformance = employeePerformance;
    }

    public Double getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(Double logisticsEfficiency) {
        this.logisticsEfficiency = logisticsEfficiency;
    }

    public Double getSupplierRating() {
        return supplierRating;
    }

    public void setSupplierRating(Double supplierRating) {
        this.supplierRating = supplierRating;
    }

    public Double getItSecurityRating() {
        return itSecurityRating;
    }

    public void setItSecurityRating(Double itSecurityRating) {
        this.itSecurityRating = itSecurityRating;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Double getQualityAssuranceScore() {
        return qualityAssuranceScore;
    }

    public void setQualityAssuranceScore(Double qualityAssuranceScore) {
        this.qualityAssuranceScore = qualityAssuranceScore;
    }

    public Double getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(Double promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public Double getFinancialStabilityIndex() {
        return financialStabilityIndex;
    }

    public void setFinancialStabilityIndex(Double financialStabilityIndex) {
        this.financialStabilityIndex = financialStabilityIndex;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public Double getEcoSustainabilityIndex() {
        return ecoSustainabilityIndex;
    }

    public void setEcoSustainabilityIndex(Double ecoSustainabilityIndex) {
        this.ecoSustainabilityIndex = ecoSustainabilityIndex;
    }

    public List<CustomConfig> getCustomConfigs() {
        return customConfigs;
    }

    public void setCustomConfigs(List<CustomConfig> customConfigs) {
        this.customConfigs = customConfigs;
    }

    public List<LegacyConfig> getLegacyConfigs() {
        return legacyConfigs;
    }

    public void setLegacyConfigs(List<LegacyConfig> legacyConfigs) {
        this.legacyConfigs = legacyConfigs;
    }
}