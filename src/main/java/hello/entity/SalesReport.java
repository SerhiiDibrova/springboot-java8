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
    @Column(name = "Order_Identifier")
    private String orderIdentifier;
    @Column(name = "Customer_FullName")
    private String customerFullName;
    @Column(name = "OrderDate")
    private LocalDate orderDate;
    @Column(name = "Sales_Status")
    private String salesStatus;
    @Column(name = "SalesDate")
    private LocalDate salesDate;
    @Column(name = "ItemId")
    private Long itemId;
    @Column(name = "Quantity")
    private Integer quantity;
    @Column(name = "Price")
    private BigDecimal price;
    @Column(name = "Product_Title")
    private String productTitle;
    @Column(name = "Product_Type")
    private String productType;
    @Column(name = "Customer_Category")
    private String customerCategory;
    @Column(name = "Discount_Status")
    private String discountStatus;
    @Column(name = "DiscountStartDate")
    private LocalDate discountStartDate;
    @Column(name = "DiscountEndDate")
    private LocalDate discountEndDate;
    @Column(name = "ShipmentId")
    private Long shipmentId;
    @Column(name = "ShippingDate")
    private LocalDate shippingDate;
    @Column(name = "ShippingCost")
    private BigDecimal shippingCost;
    @Column(name = "RegionName")
    private String regionName;
    @Column(name = "SalesTerritory")
    private String salesTerritory;
    @Column(name = "BranchId")
    private Long branchId;
    @Column(name = "BranchRevenue")
    private BigDecimal branchRevenue;
    @Column(name = "EmployeeId")
    private Long employeeId;
    @Column(name = "EmployeeName")
    private String employeeName;
    @Column(name = "Performance_Status")
    private String performanceStatus;
    @Column(name = "FinancialQuarter")
    private String financialQuarter;
    @Column(name = "AnnualRevenue")
    private BigDecimal annualRevenue;
    @Column(name = "VendorId")
    private Long vendorId;
    @Column(name = "VendorName")
    private String vendorName;
    @Column(name = "WarehouseId")
    private Long warehouseId;
    @Column(name = "WarehouseCapacity")
    private Integer warehouseCapacity;
    @Column(name = "StockLevel")
    private Integer stockLevel;
    @Column(name = "TaxRate")
    private BigDecimal taxRate;
    @Column(name = "PaymentMethod")
    private String paymentMethod;
    @Column(name = "RefundAmount")
    private BigDecimal refundAmount;
    @Column(name = "ReviewScore")
    private Integer reviewScore;
    @Column(name = "SupplierRating")
    private Integer supplierRating;
    @Column(name = "TransactionType")
    private String transactionType;
    @Column(name = "CampaignBudget")
    private BigDecimal campaignBudget;
    @Column(name = "PromotionDiscount")
    private BigDecimal promotionDiscount;
    @Column(name = "CategoryName")
    private String categoryName;
    @Column(name = "ContractValue")
    private BigDecimal contractValue;
    @Column(name = "DeliverySuccessRate")
    private BigDecimal deliverySuccessRate;
    @Column(name = "CoverageAmount")
    private BigDecimal coverageAmount;
    @Column(name = "InsuranceType")
    private String insuranceType;
    @Column(name = "RiskCategory")
    private String riskCategory;
    @Column(name = "DepartmentName")
    private String departmentName;
    @Column(name = "BudgetAllocated")
    private BigDecimal budgetAllocated;
    @Column(name = "FinancialStabilityIndex")
    private BigDecimal financialStabilityIndex;
    @Column(name = "AssetTurnoverRatio")
    private BigDecimal assetTurnoverRatio;
    @Column(name = "ManufacturingCost")
    private BigDecimal manufacturingCost;
    @Column(name = "ITSecurityRating")
    private String itSecurityRating;
    @Column(name = "QualityAssuranceScore")
    private Integer qualityAssuranceScore;
    @Column(name = "HRComplianceScore")
    private Integer hrComplianceScore;
    @Column(name = "EcoSustainabilityIndex")
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
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

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
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

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public BigDecimal getBranchRevenue() {
        return branchRevenue;
    }

    public void setBranchRevenue(BigDecimal branchRevenue) {
        this.branchRevenue = branchRevenue;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
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

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
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