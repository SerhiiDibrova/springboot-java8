package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "TempItems")
public class TempItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(nullable = true)
    private String customerSegment;

    @Column(nullable = true)
    private String regionName;

    @Column(nullable = true)
    private String productCategory;

    @Column(nullable = true)
    private BigDecimal salesAmount;

    @Column(nullable = true)
    private BigDecimal taxRate;

    @Column(nullable = true)
    private Integer stockLevel;

    @Column(nullable = true)
    private BigDecimal shippingCost;

    @Column(nullable = true)
    private Integer warehouseCapacity;

    @Column(nullable = true)
    private Integer employeePerformance;

    @Column(nullable = true)
    private BigDecimal logisticsEfficiency;

    @Column(nullable = true)
    private BigDecimal supplierRating;

    @Column(nullable = true)
    private BigDecimal itSecurityRating;

    @Column(nullable = true)
    private BigDecimal refundAmount;

    @Column(nullable = true)
    private BigDecimal qualityAssuranceScore;

    @Column(nullable = true)
    private BigDecimal promotionDiscount;

    @Column(nullable = true)
    private BigDecimal financialStabilityIndex;

    @Column(nullable = true)
    private String riskCategory;

    @Column(nullable = true)
    private BigDecimal ecoSustainabilityIndex;

    @Column(nullable = true)
    private Long configId;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable = false, updatable = false)
    private CustomConfig customConfig;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable = false, updatable = false)
    private LegacyConfig legacyConfig;

    public TempItem() {
    }

    public TempItem(Integer orderId, String customerSegment, String regionName, String productCategory, BigDecimal salesAmount, BigDecimal taxRate, Integer stockLevel, BigDecimal shippingCost, Integer warehouseCapacity, Integer employeePerformance, BigDecimal logisticsEfficiency, BigDecimal supplierRating, BigDecimal itSecurityRating, BigDecimal refundAmount, BigDecimal qualityAssuranceScore, BigDecimal promotionDiscount, BigDecimal financialStabilityIndex, String riskCategory, BigDecimal ecoSustainabilityIndex, Long configId) {
        this.orderId = orderId;
        this.customerSegment = customerSegment;
        this.regionName = regionName;
        this.productCategory = productCategory;
        this.salesAmount = salesAmount;
        this.taxRate = taxRate;
        this.stockLevel = stockLevel;
        this.shippingCost = shippingCost;
        this.warehouseCapacity = warehouseCapacity;
        this.employeePerformance = employeePerformance;
        this.logisticsEfficiency = logisticsEfficiency;
        this.supplierRating = supplierRating;
        this.itSecurityRating = itSecurityRating;
        this.refundAmount = refundAmount;
        this.qualityAssuranceScore = qualityAssuranceScore;
        this.promotionDiscount = promotionDiscount;
        this.financialStabilityIndex = financialStabilityIndex;
        this.riskCategory = riskCategory;
        this.ecoSustainabilityIndex = ecoSustainabilityIndex;
        this.configId = configId;
    }

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

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }
}