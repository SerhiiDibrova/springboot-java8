package hello.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "#SalesReport")
public class SalesReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderIdentifier;
    private String customerFullName;
    private LocalDate orderDate;
    private String salesStatus;
    private LocalDate salesDate;
    private Integer itemId;
    private Integer quantity;
    private BigDecimal price;
    private String productTitle;
    private String productType;
    private String customerCategory;
    private String discountStatus;
    private LocalDate discountStartDate;
    private LocalDate discountEndDate;
    private Integer shipmentId;
    private LocalDate shippingDate;
    private BigDecimal shippingCost;
    private String regionName;
    private String salesTerritory;
    private Integer branchId;
    private BigDecimal branchRevenue;
    private Integer employeeId;
    private String employeeName;
    private String performanceStatus;
    private String financialQuarter;
    private BigDecimal annualRevenue;
    private Integer vendorId;
    private String vendorName;
    private Integer warehouseId;
    private Integer warehouseCapacity;
    private Integer stockLevel;
    private BigDecimal taxRate;
    private String paymentMethod;
    private BigDecimal refundAmount;
    private BigDecimal reviewScore;
    private BigDecimal supplierRating;
    private String transactionType;
    private BigDecimal campaignBudget;
    private BigDecimal promotionDiscount;
    private String categoryName;
    private BigDecimal contractValue;
    private BigDecimal deliverySuccessRate;
    private BigDecimal coverageAmount;
    private String riskCategory;
    private String departmentName;
    private BigDecimal budgetAllocated;
    private BigDecimal financialStabilityIndex;
    private BigDecimal assetTurnoverRatio;
    private BigDecimal manufacturingCost;
    private String itSecurityRating;
    private Integer qualityAssuranceScore;
    private Integer hrComplianceScore;
    private BigDecimal ecoSustainabilityIndex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderIdentifier() {
        return orderIdentifier;
    }

    public void setOrderIdentifier(String orderIdentifier) {
        this.orderIdentifier = orderIdentifier;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public LocalDate getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(LocalDate salesDate) {
        this.salesDate = salesDate;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

    public String getDiscountStatus() {
        return discountStatus;
    }

    public void setDiscountStatus(String discountStatus) {
        this.discountStatus = discountStatus;
    }

    public LocalDate getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(LocalDate discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public LocalDate getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(LocalDate discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getSalesTerritory() {
        return salesTerritory;
    }

    public void setSalesTerritory(String salesTerritory) {
        this.salesTerritory = salesTerritory;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public BigDecimal getBranchRevenue() {
        return branchRevenue;
    }

    public void setBranchRevenue(BigDecimal branchRevenue) {
        this.branchRevenue = branchRevenue;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPerformanceStatus() {
        return performanceStatus;
    }

    public void setPerformanceStatus(String performanceStatus) {
        this.performanceStatus = performanceStatus;
    }

    public String getFinancialQuarter() {
        return financialQuarter;
    }

    public void setFinancialQuarter(String financialQuarter) {
        this.financialQuarter = financialQuarter;
    }

    public BigDecimal getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(BigDecimal annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(Integer warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(BigDecimal reviewScore) {
        this.reviewScore = reviewScore;
    }

    public BigDecimal getSupplierRating() {
        return supplierRating;
    }

    public void setSupplierRating(BigDecimal supplierRating) {
        this.supplierRating = supplierRating;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getCampaignBudget() {
        return campaignBudget;
    }

    public void setCampaignBudget(BigDecimal campaignBudget) {
        this.campaignBudget = campaignBudget;
    }

    public BigDecimal getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(BigDecimal promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getContractValue() {
        return contractValue;
    }

    public void setContractValue(BigDecimal contractValue) {
        this.contractValue = contractValue;
    }

    public BigDecimal getDeliverySuccessRate() {
        return deliverySuccessRate;
    }

    public void setDeliverySuccessRate(BigDecimal deliverySuccessRate) {
        this.deliverySuccessRate = deliverySuccessRate;
    }

    public BigDecimal getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(BigDecimal coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public BigDecimal getBudgetAllocated() {
        return budgetAllocated;
    }

    public void setBudgetAllocated(BigDecimal budgetAllocated) {
        this.budgetAllocated = budgetAllocated;
    }

    public BigDecimal getFinancialStabilityIndex() {
        return financialStabilityIndex;
    }

    public void setFinancialStabilityIndex(BigDecimal financialStabilityIndex) {
        this.financialStabilityIndex = financialStabilityIndex;
    }

    public BigDecimal getAssetTurnoverRatio() {
        return assetTurnoverRatio;
    }

    public void setAssetTurnoverRatio(BigDecimal assetTurnoverRatio) {
        this.assetTurnoverRatio = assetTurnoverRatio;
    }

    public BigDecimal getManufacturingCost() {
        return manufacturingCost;
    }

    public void setManufacturingCost(BigDecimal manufacturingCost) {
        this.manufacturingCost = manufacturingCost;
    }

    public String getItSecurityRating() {
        return itSecurityRating;
    }

    public void setItSecurityRating(String itSecurityRating) {
        this.itSecurityRating = itSecurityRating;
    }

    public Integer getQualityAssuranceScore() {
        return qualityAssuranceScore;
    }

    public void setQualityAssuranceScore(Integer qualityAssuranceScore) {
        this.qualityAssuranceScore = qualityAssuranceScore;
    }

    public Integer getHrComplianceScore() {
        return hrComplianceScore;
    }

    public void setHrComplianceScore(Integer hrComplianceScore) {
        this.hrComplianceScore = hrComplianceScore;
    }

    public BigDecimal getEcoSustainabilityIndex() {
        return ecoSustainabilityIndex;
    }

    public void setEcoSustainabilityIndex(BigDecimal ecoSustainabilityIndex) {
        this.ecoSustainabilityIndex = ecoSustainabilityIndex;
    }
}