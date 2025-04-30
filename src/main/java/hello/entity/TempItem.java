package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "TempItems", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"orderId", "configId"})
})
public class TempItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer orderId;

    @Column(name = "configId")
    @NotNull
    private Integer configId;

    @Column(name = "customerSegment")
    private String customerSegment;

    @Column(name = "regionName")
    private String regionName;

    @Column(name = "productCategory")
    private String productCategory;

    @Column(name = "salesAmount")
    private BigDecimal salesAmount;

    @Column(name = "taxRate")
    private BigDecimal taxRate;

    @Column(name = "stockLevel")
    private Integer stockLevel;

    @Column(name = "shippingCost")
    private BigDecimal shippingCost;

    @Column(name = "warehouseCapacity")
    private Integer warehouseCapacity;

    @Column(name = "employeePerformance")
    private Integer employeePerformance;

    @Column(name = "logisticsEfficiency")
    private BigDecimal logisticsEfficiency;

    @Column(name = "supplierRating")
    private BigDecimal supplierRating;

    @Column(name = "itSecurityRating")
    private BigDecimal itSecurityRating;

    @Column(name = "refundAmount")
    private BigDecimal refundAmount;

    @Column(name = "qualityAssuranceScore")
    private BigDecimal qualityAssuranceScore;

    @Column(name = "promotionDiscount")
    private BigDecimal promotionDiscount;

    @Column(name = "financialStabilityIndex")
    private BigDecimal financialStabilityIndex;

    @Column(name = "riskCategory")
    private String riskCategory;

    @Column(name = "ecoSustainabilityIndex")
    private BigDecimal ecoSustainabilityIndex;

    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
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
}