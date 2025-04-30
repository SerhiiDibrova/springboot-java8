package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesReportDTO {

    @NotNull
    @JsonProperty("orderIdentifier")
    private String orderIdentifier;

    @NotNull
    @JsonProperty("customerFullName")
    private String customerFullName;

    @JsonProperty("orderDate")
    private LocalDate orderDate;

    @NotNull
    @JsonProperty("salesStatus")
    private String salesStatus;

    @JsonProperty("salesDate")
    private LocalDate salesDate;

    @JsonProperty("itemId")
    private Integer itemId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @JsonProperty("productTitle")
    private String productTitle;

    @NotNull
    @JsonProperty("productType")
    private String productType;

    @JsonProperty("customerCategory")
    private String customerCategory;

    @NotNull
    @JsonProperty("discountStatus")
    private String discountStatus;

    @JsonProperty("discountStartDate")
    private LocalDate discountStartDate;

    @JsonProperty("discountEndDate")
    private LocalDate discountEndDate;

    @JsonProperty("shipmentId")
    private Integer shipmentId;

    @JsonProperty("shippingDate")
    private LocalDate shippingDate;

    @JsonProperty("shippingCost")
    private BigDecimal shippingCost;

    @NotNull
    @JsonProperty("regionName")
    private String regionName;

    @NotNull
    @JsonProperty("salesTerritory")
    private String salesTerritory;

    @JsonProperty("branchId")
    private Integer branchId;

    @JsonProperty("branchRevenue")
    private BigDecimal branchRevenue;

    @JsonProperty("employeeId")
    private Integer employeeId;

    @NotNull
    @JsonProperty("employeeName")
    private String employeeName;

    @NotNull
    @JsonProperty("performanceStatus")
    private String performanceStatus;

    @NotNull
    @JsonProperty("financialQuarter")
    private String financialQuarter;

    @JsonProperty("annualRevenue")
    private BigDecimal annualRevenue;

    @JsonProperty("vendorId")
    private Integer vendorId;

    @NotNull
    @JsonProperty("vendorName")
    private String vendorName;

    @JsonProperty("warehouseId")
    private Integer warehouseId;

    @JsonProperty("warehouseCapacity")
    private Integer warehouseCapacity;

    @JsonProperty("stockLevel")
    private Integer stockLevel;

    @JsonProperty("taxRate")
    private BigDecimal taxRate;

    @NotNull
    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @JsonProperty("refundAmount")
    private BigDecimal refundAmount;

    @JsonProperty("reviewScore")
    private BigDecimal reviewScore;

    @JsonProperty("supplierRating")
    private BigDecimal supplierRating;

    @NotNull
    @JsonProperty("transactionType")
    private String transactionType;

    @JsonProperty("campaignBudget")
    private BigDecimal campaignBudget;

    @JsonProperty("promotionDiscount")
    private BigDecimal promotionDiscount;

    @NotNull
    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("contractValue")
    private BigDecimal contractValue;

    @JsonProperty("deliverySuccessRate")
    private BigDecimal deliverySuccessRate;

    @JsonProperty("coverageAmount")
    private BigDecimal coverageAmount;

    @NotNull
    @JsonProperty("riskCategory")
    private String riskCategory;

    @NotNull
    @JsonProperty("departmentName")
    private String departmentName;

    @JsonProperty("budgetAllocated")
    private BigDecimal budgetAllocated;

    @JsonProperty("logisticsEfficiency")
    private BigDecimal logisticsEfficiency;

    @NotNull
    @JsonProperty("insuranceType")
    private String insuranceType;

    @JsonProperty("financialStabilityIndex")
    private BigDecimal financialStabilityIndex;

    @JsonProperty("assetTurnoverRatio")
    private BigDecimal assetTurnoverRatio;

    @JsonProperty("manufacturingCost")
    private BigDecimal manufacturingCost;

    @JsonProperty("itSecurityRating")
    private BigDecimal itSecurityRating;

    @JsonProperty("qualityAssuranceScore")
    private BigDecimal qualityAssuranceScore;

    @JsonProperty("hrComplianceScore")
    private BigDecimal hrComplianceScore;

    @JsonProperty("ecoSustainabilityIndex")
    private BigDecimal ecoSustainabilityIndex;

    public SalesReportDTO() {
    }

    public SalesReportDTO(String orderIdentifier, String customerFullName, LocalDate orderDate, String salesStatus, LocalDate salesDate, Integer itemId, Integer quantity, BigDecimal price, String productTitle, String productType, String customerCategory, String discountStatus, LocalDate discountStartDate, LocalDate discountEndDate, Integer shipmentId, LocalDate shippingDate, BigDecimal shippingCost, String regionName, String salesTerritory, Integer branchId, BigDecimal branchRevenue, Integer employeeId, String employeeName, String performanceStatus, String financialQuarter, BigDecimal annualRevenue, Integer vendorId, String vendorName, Integer warehouseId, Integer warehouseCapacity, Integer stockLevel, BigDecimal taxRate, String paymentMethod, BigDecimal refundAmount, BigDecimal reviewScore, BigDecimal supplierRating, String transactionType, BigDecimal campaignBudget, BigDecimal promotionDiscount, String categoryName, BigDecimal contractValue, BigDecimal deliverySuccessRate, BigDecimal coverageAmount, String riskCategory, String departmentName, BigDecimal budgetAllocated, BigDecimal logisticsEfficiency, String insuranceType, BigDecimal financialStabilityIndex, BigDecimal assetTurnoverRatio, BigDecimal manufacturingCost, BigDecimal itSecurityRating, BigDecimal qualityAssuranceScore, BigDecimal hrComplianceScore, BigDecimal ecoSustainabilityIndex) {
        this.orderIdentifier = orderIdentifier;
        this.customerFullName = customerFullName;
        this.orderDate = orderDate;
        this.salesStatus = salesStatus;
        this.salesDate = salesDate;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.productTitle = productTitle;
        this.productType = productType;
        this.customerCategory = customerCategory;
        this.discountStatus = discountStatus;
        this.discountStartDate = discountStartDate;
        this.discountEndDate = discountEndDate;
        this.shipmentId = shipmentId;
        this.shippingDate = shippingDate;
        this.shippingCost = shippingCost;
        this.regionName = regionName;
        this.salesTerritory = salesTerritory;
        this.branchId = branchId;
        this.branchRevenue = branchRevenue;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.performanceStatus = performanceStatus;
        this.financialQuarter = financialQuarter;
        this.annualRevenue = annualRevenue;
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.warehouseId = warehouseId;
        this.warehouseCapacity = warehouseCapacity;
        this.stockLevel = stockLevel;
        this.taxRate = taxRate;
        this.paymentMethod = paymentMethod;
        this.refundAmount = refundAmount;
        this.reviewScore = reviewScore;
        this.supplierRating = supplierRating;
        this.transactionType = transactionType;
        this.campaignBudget = campaignBudget;
        this.promotionDiscount = promotionDiscount;
        this.categoryName = categoryName;
        this.contractValue = contractValue;
        this.deliverySuccessRate = deliverySuccessRate;
        this.coverageAmount = coverageAmount;
        this.riskCategory = riskCategory;
        this.departmentName = departmentName;
        this.budgetAllocated = budgetAllocated;
        this.logisticsEfficiency = logisticsEfficiency;
        this.insuranceType = insuranceType;
        this.financialStabilityIndex = financialStabilityIndex;
        this.assetTurnoverRatio = assetTurnoverRatio;
        this.manufacturingCost = manufacturingCost;
        this.itSecurityRating = itSecurityRating;
        this.qualityAssuranceScore = qualityAssuranceScore;
        this.hrComplianceScore = hrComplianceScore;
        this.ecoSustainabilityIndex = ecoSustainabilityIndex;
    }

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

    public BigDecimal getItSecurityRating() {
        return itSecurityRating;
    }

    public void setItSecurityRating(BigDecimal itSecurityRating) {
        this.itSecurityRating = itSecurityRating;
    }

    public BigDecimal getQualityAssuranceScore() {
        return qualityAssuranceScore;
    }

    public void setQualityAssuranceScore(BigDecimal qualityAssuranceScore) {
        this.qualityAssuranceScore = qualityAssuranceScore;
    }

    public BigDecimal getHrComplianceScore() {
        return hrComplianceScore;
    }

    public void setHrComplianceScore(BigDecimal hrComplianceScore) {
        this.hrComplianceScore = hrComplianceScore;
    }

    public BigDecimal getEcoSustainabilityIndex() {
        return ecoSustainabilityIndex;
    }

    public void setEcoSustainabilityIndex(BigDecimal ecoSustainabilityIndex) {
        this.ecoSustainabilityIndex = ecoSustainabilityIndex;
    }
}