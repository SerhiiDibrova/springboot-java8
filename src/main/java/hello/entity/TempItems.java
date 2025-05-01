package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "#TempItems")
public class TempItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private Integer orderId;

    @Size(max = 50)
    @Column(name = "CustomerSegment")
    private String customerSegment;

    @Size(max = 50)
    @Column(name = "RegionName")
    private String regionName;

    @Size(max = 50)
    @Column(name = "ProductCategory")
    private String productCategory;

    @Column(name = "SalesAmount", nullable = true)
    private BigDecimal salesAmount;

    @Column(name = "TaxRate", nullable = true)
    private BigDecimal taxRate;

    @Column(name = "StockLevel", nullable = true)
    private Integer stockLevel;

    @Column(name = "ShippingCost", nullable = true)
    private BigDecimal shippingCost;

    @Column(name = "WarehouseCapacity", nullable = true)
    private Integer warehouseCapacity;

    @Column(name = "EmployeePerformance", nullable = true)
    private Integer employeePerformance;

    @Column(name = "LogisticsEfficiency", nullable = true)
    private BigDecimal logisticsEfficiency;

    @Column(name = "SupplierRating", nullable = true)
    private BigDecimal supplierRating;

    @Column(name = "ITSecurityRating", nullable = true)
    private BigDecimal itSecurityRating;

    @Column(name = "RefundAmount", nullable = true)
    private BigDecimal refundAmount;

    @Column(name = "QualityAssuranceScore", nullable = true)
    private BigDecimal qualityAssuranceScore;

    @Column(name = "PromotionDiscount", nullable = true)
    private BigDecimal promotionDiscount;

    @Column(name = "FinancialStabilityIndex", nullable = true)
    private BigDecimal financialStabilityIndex;

    @Size(max = 50)
    @Column(name = "RiskCategory")
    private String riskCategory;

    @Column(name = "EcoSustainabilityIndex", nullable = true)
    private BigDecimal ecoSustainabilityIndex;

    @NotNull
    @Column(name = "config_id")
    private Integer configId;

    @Size(max = 255)
    @Column(length = 255)
    private String itemDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }
}