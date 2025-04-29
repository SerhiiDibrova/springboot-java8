package hello.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "TempItems")
public class TempItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "OrderId", nullable = false)
    @NotNull
    private String orderId;

    @Column(name = "CustomerSegment", nullable = false)
    @NotNull
    private String customerSegment;

    @Column(name = "RegionName", nullable = false)
    @NotNull
    private String regionName;

    @Column(name = "ProductCategory", nullable = false)
    @NotNull
    private String productCategory;

    @Column(name = "SalesAmount", nullable = false)
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal salesAmount;

    @Column(name = "TaxRate", nullable = false)
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("1.0")
    private BigDecimal taxRate;

    @Column(name = "StockLevel", nullable = false)
    @NotNull
    @Min(0)
    private Integer stockLevel;

    @Column(name = "ShippingCost", nullable = false)
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal shippingCost;

    @Column(name = "WarehouseCapacity", nullable = false)
    @NotNull
    @Min(0)
    private Integer warehouseCapacity;

    @Column(name = "EmployeePerformance", nullable = false)
    @NotNull
    @Min(0)
    private Integer employeePerformance;

    @Column(name = "LogisticsEfficiency", nullable = false)
    @NotNull
    @Min(0)
    private Integer logisticsEfficiency;

    @Column(name = "SupplierRating", nullable = false)
    @NotNull
    @Min(0)
    private Integer supplierRating;

    @Column(name = "ITSecurityRating", nullable = false)
    @NotNull
    @Min(0)
    private Integer itSecurityRating;

    @Column(name = "RefundAmount", nullable = false)
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal refundAmount;

    @Column(name = "QualityAssuranceScore", nullable = false)
    @NotNull
    @Min(0)
    private Integer qualityAssuranceScore;

    @Column(name = "PromotionDiscount", nullable = false)
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal promotionDiscount;

    @Column(name = "FinancialStabilityIndex", nullable = false)
    @NotNull
    @Min(0)
    private Integer financialStabilityIndex;

    @Column(name = "RiskCategory", nullable = false)
    @NotNull
    private String riskCategory;

    @Column(name = "EcoSustainabilityIndex", nullable = false)
    @NotNull
    @Min(0)
    private Integer ecoSustainabilityIndex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
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

    public Integer getEcoSustainabilityIndex() {
        return ecoSustainabilityIndex;
    }

    public void setEcoSustainabilityIndex(Integer ecoSustainabilityIndex) {
        this.ecoSustainabilityIndex = ecoSustainabilityIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TempItem)) return false;
        TempItem tempItem = (TempItem) o;
        return Objects.equals(id, tempItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}