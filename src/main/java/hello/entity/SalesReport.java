package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "SalesReport")
public class SalesReport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "Order_Identifier", nullable = false)
    private String orderIdentifier;

    @NotNull
    @Column(name = "Customer_FullName", nullable = false)
    private String customerFullName;

    @NotNull
    @Column(name = "OrderDate", nullable = false)
    private LocalDate orderDate;

    @NotNull
    @Column(name = "Sales_Status", nullable = false)
    private String salesStatus;

    @NotNull
    @Column(name = "SalesDate", nullable = false)
    private LocalDate salesDate;

    @NotNull
    @Column(name = "ItemId", nullable = false)
    private Integer itemId;

    @NotNull
    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @NotNull
    @Column(name = "Product_Title", nullable = false)
    private String productTitle;

    @NotNull
    @Column(name = "Product_Type", nullable = false)
    private String productType;

    @NotNull
    @Column(name = "Customer_Category", nullable = false)
    private String customerCategory;

    @NotNull
    @Column(name = "Discount_Status", nullable = false)
    private String discountStatus;

    @Column(name = "DiscountStartDate")
    private LocalDate discountStartDate;

    @Column(name = "DiscountEndDate")
    private LocalDate discountEndDate;

    @Column(name = "ShipmentId")
    private Integer shipmentId;

    @Column(name = "ShippingDate")
    private LocalDate shippingDate;

    @Column(name = "ShippingCost")
    private BigDecimal shippingCost;

    @NotNull
    @Column(name = "RegionName", nullable = false)
    private String regionName;

    @NotNull
    @Column(name = "SalesTerritory", nullable = false)
    private String salesTerritory;

    @NotNull
    @Column(name = "BranchId", nullable = false)
    private Integer branchId;

    @NotNull
    @Column(name = "BranchRevenue", nullable = false)
    private BigDecimal branchRevenue;

    @NotNull
    @Column(name = "EmployeeId", nullable = false)
    private Integer employeeId;

    @NotNull
    @Column(name = "EmployeeName", nullable = false)
    private String employeeName;

    @NotNull
    @Column(name = "Performance_Status", nullable = false)
    private String performanceStatus;

    @NotNull
    @Column(name = "FinancialQuarter", nullable = false)
    private String financialQuarter;

    @NotNull
    @Column(name = "AnnualRevenue", nullable = false)
    private BigDecimal annualRevenue;

    @NotNull
    @Column(name = "VendorId", nullable = false)
    private Integer vendorId;

    @NotNull
    @Column(name = "VendorName", nullable = false)
    private String vendorName;

    @NotNull
    @Column(name = "WarehouseId", nullable = false)
    private Integer warehouseId;

    @NotNull
    @Column(name = "WarehouseCapacity", nullable = false)
    private Integer warehouseCapacity;

    @NotNull
    @Column(name = "StockLevel", nullable = false)
    private Integer stockLevel;

    @NotNull
    @Column(name = "TaxRate", nullable = false)
    private BigDecimal taxRate;

    @NotNull
    @Column(name = "PaymentMethod", nullable = false)
    private String paymentMethod;

    @Column(name = "RefundAmount")
    private BigDecimal refundAmount;

    @Column(name = "ReviewScore")
    private Integer reviewScore;

    @Column(name = "SupplierRating")
    private Integer supplierRating;

    @NotNull
    @Column(name = "TransactionType", nullable = false)
    private String transactionType;

    @NotNull
    @Column(name = "CampaignBudget", nullable = false)
    private BigDecimal campaignBudget;

    @NotNull
    @Column(name = "PromotionDiscount", nullable = false)
    private BigDecimal promotionDiscount;

    @NotNull
    @Column(name = "CategoryName", nullable = false)
    private String categoryName;

    @NotNull
    @Column(name = "ContractValue", nullable = false)
    private BigDecimal contractValue;

    @NotNull
    @Column(name = "DeliverySuccessRate", nullable = false)
    private BigDecimal deliverySuccessRate;

    @NotNull
    @Column(name = "CoverageAmount", nullable = false)
    private BigDecimal coverageAmount;

    @NotNull
    @Column(name = "InsuranceType", nullable = false)
    private String insuranceType;

    @NotNull
    @Column(name = "RiskCategory", nullable = false)
    private String riskCategory;

    @NotNull
    @Column(name = "DepartmentName", nullable = false)
    private String departmentName;

    @NotNull
    @Column(name = "BudgetAllocated", nullable = false)
    private BigDecimal budgetAllocated;

    @NotNull
    @Column(name = "FinancialStabilityIndex", nullable = false)
    private BigDecimal financialStabilityIndex;

    @NotNull
    @Column(name = "AssetTurnoverRatio", nullable = false)
    private BigDecimal assetTurnoverRatio;

    @NotNull
    @Column(name = "ManufacturingCost", nullable = false)
    private BigDecimal manufacturingCost;

    @NotNull
    @Column(name = "ITSecurityRating", nullable = false)
    private Integer itSecurityRating;

    @NotNull
    @Column(name = "QualityAssuranceScore", nullable = false)
    private Integer qualityAssuranceScore;

    @NotNull
    @Column(name = "HRComplianceScore", nullable = false)
    private Integer hrComplianceScore;

    @NotNull
    @Column(name = "EcoSustainabilityIndex", nullable = false)
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

    public Integer getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(Integer reviewScore) {
        this.reviewScore = reviewScore;
    }

    public Integer getSupplierRating() {
        return supplierRating;
    }

    public void setSupplierRating(Integer supplierRating) {
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

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
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

    public Integer getItSecurityRating() {
        return itSecurityRating;
    }

    public void setItSecurityRating(Integer itSecurityRating) {
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