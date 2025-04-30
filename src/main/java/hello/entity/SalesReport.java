package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "#SalesReport")
public class SalesReport {

    @NotNull
    @Column(name = "Order_Identifier")
    private String orderIdentifier;

    @NotNull
    @Size(max = 255)
    @Column(name = "Customer_FullName")
    private String customerFullName;

    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @NotNull
    @Column(name = "Sales_Status")
    private String salesStatus;

    @Column(name = "SalesDate")
    private LocalDate salesDate;

    @Column(name = "ItemId")
    private Integer itemId;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Price")
    private BigDecimal price;

    @Size(max = 255)
    @Column(name = "Product_Title")
    private String productTitle;

    @Size(max = 255)
    @Column(name = "Product_Type")
    private String productType;

    @Size(max = 255)
    @Column(name = "Customer_Category")
    private String customerCategory;

    @NotNull
    @Column(name = "Discount_Status")
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

    @Size(max = 255)
    @Column(name = "RegionName")
    private String regionName;

    @Size(max = 255)
    @Column(name = "SalesTerritory")
    private String salesTerritory;

    @Column(name = "BranchId")
    private Integer branchId;

    @Column(name = "BranchRevenue")
    private BigDecimal branchRevenue;

    @Column(name = "EmployeeId")
    private Integer employeeId;

    @Size(max = 255)
    @Column(name = "EmployeeName")
    private String employeeName;

    @NotNull
    @Column(name = "Performance_Status")
    private String performanceStatus;

    @Size(max = 255)
    @Column(name = "FinancialQuarter")
    private String financialQuarter;

    @Column(name = "AnnualRevenue")
    private BigDecimal annualRevenue;

    @Column(name = "VendorId")
    private Integer vendorId;

    @Size(max = 255)
    @Column(name = "VendorName")
    private String vendorName;

    @Column(name = "WarehouseId")
    private Integer warehouseId;

    @Column(name = "WarehouseCapacity")
    private Integer warehouseCapacity;

    @Column(name = "StockLevel")
    private Integer stockLevel;

    @Column(name = "TaxRate")
    private BigDecimal taxRate;

    @Size(max = 255)
    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @Column(name = "RefundAmount")
    private BigDecimal refundAmount;

    @Column(name = "ReviewScore")
    private BigDecimal reviewScore;

    @Column(name = "SupplierRating")
    private BigDecimal supplierRating;

    @Size(max = 255)
    @Column(name = "TransactionType")
    private String transactionType;

    @Column(name = "CampaignBudget")
    private BigDecimal campaignBudget;

    @Column(name = "PromotionDiscount")
    private BigDecimal promotionDiscount;

    @Size(max = 255)
    @Column(name = "CategoryName")
    private String categoryName;

    @Column(name = "ContractValue")
    private BigDecimal contractValue;

    @Column(name = "DeliverySuccessRate")
    private BigDecimal deliverySuccessRate;

    @Column(name = "CoverageAmount")
    private BigDecimal coverageAmount;

    @Size(max = 255)
    @Column(name = "RiskCategory")
    private String riskCategory;

    @Size(max = 255)
    @Column(name = "DepartmentName")
    private String departmentName;

    @Column(name = "BudgetAllocated")
    private BigDecimal budgetAllocated;

    @Column(name = "LogisticsEfficiency")
    private BigDecimal logisticsEfficiency;

    @Size(max = 255)
    @Column(name = "InsuranceType")
    private String insuranceType;

    @Column(name = "FinancialStabilityIndex")
    private BigDecimal financialStabilityIndex;

    @Column(name = "AssetTurnoverRatio")
    private BigDecimal assetTurnoverRatio;

    @Column(name = "ManufacturingCost")
    private BigDecimal manufacturingCost;

    @Column(name = "ITSecurityRating")
    private BigDecimal itSecurityRating;

    @Column(name = "QualityAssuranceScore")
    private BigDecimal qualityAssuranceScore;

    @Column(name = "HRComplianceScore")
    private BigDecimal hrComplianceScore;

    @Column(name = "EcoSustainabilityIndex")
    private BigDecimal ecoSustainabilityIndex;

    @NotNull
    @Column(name = "Manager_Id")
    private Long managerId;

    @Size(max = 4000)
    @Column(name = "Xml_Data")
    private String xmlData;

    @Column(name = "Is_Audit_Needed", columnDefinition = "boolean default false")
    private Boolean isAuditNeeded = false;

    // Getters and Setters
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

    public BigDecimal getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(BigDecimal logisticsEfficiency) {
        this.logisticsEfficiency = logisticsEfficiency;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
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

    public BigDecimal getITSecurityRating() {
        return itSecurityRating;
    }

    public void setITSecurityRating(BigDecimal itSecurityRating) {
        this.itSecurityRating = itSecurityRating;
    }

    public BigDecimal getQualityAssuranceScore() {
        return qualityAssuranceScore;
    }

    public void setQualityAssuranceScore(BigDecimal qualityAssuranceScore) {
        this.qualityAssuranceScore = qualityAssuranceScore;
    }

    public BigDecimal getHRComplianceScore() {
        return hrComplianceScore;
    }

    public void setHRComplianceScore(BigDecimal hrComplianceScore) {
        this.hrComplianceScore = hrComplianceScore;
    }

    public BigDecimal getEcoSustainabilityIndex() {
        return ecoSustainabilityIndex;
    }

    public void setEcoSustainabilityIndex(BigDecimal ecoSustainabilityIndex) {
        this.ecoSustainabilityIndex = ecoSustainabilityIndex;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getXmlData() {
        return xmlData;
    }

    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }

    public Boolean getIsAuditNeeded() {
        return isAuditNeeded;
    }

    public void setIsAuditNeeded(Boolean isAuditNeeded) {
        this.isAuditNeeded = isAuditNeeded;
    }
}