package hello.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesReportDTO {
    private Long orderIdentifier;
    private String customerFullName;
    private LocalDate orderDate;
    private String salesStatus;
    private LocalDate salesDate;
    private Long itemId;
    private Integer quantity;
    private BigDecimal price;
    private String productTitle;
    private String productType;
    private String customerCategory;
    private String discountStatus;
    private LocalDate discountStartDate;
    private LocalDate discountEndDate;
    private Long shipmentId;
    private LocalDate shippingDate;
    private BigDecimal shippingCost;
    private String regionName;
    private String salesTerritory;
    private Long branchId;
    private BigDecimal branchRevenue;
    private Long employeeId;
    private String employeeName;
    private String performanceStatus;
    private String financialQuarter;
    private BigDecimal annualRevenue;
    private Long vendorId;
    private String vendorName;
    private Long warehouseId;
    private Integer warehouseCapacity;
    private Integer stockLevel;
    private BigDecimal taxRate;
    private String paymentMethod;
    private BigDecimal refundAmount;
    private Integer reviewScore;
    private Integer supplierRating;
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

    public SalesReportDTO() {
    }

    public SalesReportDTO(Long orderIdentifier, String customerFullName, LocalDate orderDate, String salesStatus, LocalDate salesDate, Long itemId, Integer quantity, BigDecimal price, String productTitle, String productType, String customerCategory, String discountStatus, LocalDate discountStartDate, LocalDate discountEndDate, Long shipmentId, LocalDate shippingDate, BigDecimal shippingCost, String regionName, String salesTerritory, Long branchId, BigDecimal branchRevenue, Long employeeId, String employeeName, String performanceStatus, String financialQuarter, BigDecimal annualRevenue, Long vendorId, String vendorName, Long warehouseId, Integer warehouseCapacity, Integer stockLevel, BigDecimal taxRate, String paymentMethod, BigDecimal refundAmount, Integer reviewScore, Integer supplierRating, String transactionType, BigDecimal campaignBudget, BigDecimal promotionDiscount, String categoryName, BigDecimal contractValue, BigDecimal deliverySuccessRate, BigDecimal coverageAmount, String riskCategory, String departmentName, BigDecimal budgetAllocated, BigDecimal financialStabilityIndex, BigDecimal assetTurnoverRatio, BigDecimal manufacturingCost, String itSecurityRating, Integer qualityAssuranceScore, Integer hrComplianceScore, BigDecimal ecoSustainabilityIndex) {
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
        this.financialStabilityIndex = financialStabilityIndex;
        this.assetTurnoverRatio = assetTurnoverRatio;
        this.manufacturingCost = manufacturingCost;
        this.itSecurityRating = itSecurityRating;
        this.qualityAssuranceScore = qualityAssuranceScore;
        this.hrComplianceScore = hrComplianceScore;
        this.ecoSustainabilityIndex = ecoSustainabilityIndex;
    }

    public Long getOrderIdentifier() {
        return orderIdentifier;
    }

    public void setOrderIdentifier(Long orderIdentifier) {
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