package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDate;
import java.util.Objects;

public class SalesReportDTO implements Serializable {
    @JsonProperty("orderIdentifier")
    private String orderIdentifier;

    @JsonProperty("customerFullName")
    private String customerFullName;

    @JsonProperty("orderDate")
    private LocalDate orderDate;

    @JsonProperty("salesStatus")
    private String salesStatus;

    @JsonProperty("salesDate")
    private Date salesDate;

    @JsonProperty("itemId")
    private Integer itemId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("productTitle")
    private String productTitle;

    @JsonProperty("productType")
    private String productType;

    @JsonProperty("customerCategory")
    private String customerCategory;

    @JsonProperty("discountStatus")
    private String discountStatus;

    @JsonProperty("discountStartDate")
    private Date discountStartDate;

    @JsonProperty("discountEndDate")
    private Date discountEndDate;

    @JsonProperty("shipmentId")
    private Integer shipmentId;

    @JsonProperty("shippingDate")
    private Date shippingDate;

    @JsonProperty("shippingCost")
    private BigDecimal shippingCost;

    @JsonProperty("regionName")
    private String regionName;

    @JsonProperty("salesTerritory")
    private String salesTerritory;

    @JsonProperty("branchId")
    private Integer branchId;

    @JsonProperty("branchRevenue")
    private BigDecimal branchRevenue;

    @JsonProperty("employeeId")
    private Integer employeeId;

    @JsonProperty("employeeName")
    private String employeeName;

    @JsonProperty("performanceStatus")
    private String performanceStatus;

    @JsonProperty("financialQuarter")
    private String financialQuarter;

    @JsonProperty("annualRevenue")
    private BigDecimal annualRevenue;

    @JsonProperty("vendorId")
    private Integer vendorId;

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

    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @JsonProperty("refundAmount")
    private BigDecimal refundAmount;

    @JsonProperty("reviewScore")
    private BigDecimal reviewScore;

    @JsonProperty("supplierRating")
    private BigDecimal supplierRating;

    @JsonProperty("transactionType")
    private String transactionType;

    @JsonProperty("campaignBudget")
    private BigDecimal campaignBudget;

    @JsonProperty("promotionDiscount")
    private BigDecimal promotionDiscount;

    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("contractValue")
    private BigDecimal contractValue;

    @JsonProperty("deliverySuccessRate")
    private BigDecimal deliverySuccessRate;

    @JsonProperty("coverageAmount")
    private BigDecimal coverageAmount;

    @JsonProperty("riskCategory")
    private String riskCategory;

    @JsonProperty("departmentName")
    private String departmentName;

    @JsonProperty("budgetAllocated")
    private BigDecimal budgetAllocated;

    @JsonProperty("logisticsEfficiency")
    private BigDecimal logisticsEfficiency;

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

    public SalesReportDTO() {}

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

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
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

    public Date getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(Date discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public Date getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(Date discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesReportDTO)) return false;
        SalesReportDTO that = (SalesReportDTO) o;
        return Objects.equals(orderIdentifier, that.orderIdentifier) &&
                Objects.equals(customerFullName, that.customerFullName) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(salesStatus, that.salesStatus) &&
                Objects.equals(salesDate, that.salesDate) &&
                Objects.equals(itemId, that.itemId) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(price, that.price) &&
                Objects.equals(productTitle, that.productTitle) &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(customerCategory, that.customerCategory) &&
                Objects.equals(discountStatus, that.discountStatus) &&
                Objects.equals(discountStartDate, that.discountStartDate) &&
                Objects.equals(discountEndDate, that.discountEndDate) &&
                Objects.equals(shipmentId, that.shipmentId) &&
                Objects.equals(shippingDate, that.shippingDate) &&
                Objects.equals(shippingCost, that.shippingCost) &&
                Objects.equals(regionName, that.regionName) &&
                Objects.equals(salesTerritory, that.salesTerritory) &&
                Objects.equals(branchId, that.branchId) &&
                Objects.equals(branchRevenue, that.branchRevenue) &&
                Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(employeeName, that.employeeName) &&
                Objects.equals(performanceStatus, that.performanceStatus) &&
                Objects.equals(financialQuarter, that.financialQuarter) &&
                Objects.equals(annualRevenue, that.annualRevenue) &&
                Objects.equals(vendorId, that.vendorId) &&
                Objects.equals(vendorName, that.vendorName) &&
                Objects.equals(warehouseId, that.warehouseId) &&
                Objects.equals(warehouseCapacity, that.warehouseCapacity) &&
                Objects.equals(stockLevel, that.stockLevel) &&
                Objects.equals(taxRate, that.taxRate) &&
                Objects.equals(paymentMethod, that.paymentMethod) &&
                Objects.equals(refundAmount, that.refundAmount) &&
                Objects.equals(reviewScore, that.reviewScore) &&
                Objects.equals(supplierRating, that.supplierRating) &&
                Objects.equals(transactionType, that.transactionType) &&
                Objects.equals(campaignBudget, that.campaignBudget) &&
                Objects.equals(promotionDiscount, that.promotionDiscount) &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(contractValue, that.contractValue) &&
                Objects.equals(deliverySuccessRate, that.deliverySuccessRate) &&
                Objects.equals(coverageAmount, that.coverageAmount) &&
                Objects.equals(riskCategory, that.riskCategory) &&
                Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(budgetAllocated, that.budgetAllocated) &&
                Objects.equals(logisticsEfficiency, that.logisticsEfficiency) &&
                Objects.equals(insuranceType, that.insuranceType) &&
                Objects.equals(financialStabilityIndex, that.financialStabilityIndex) &&
                Objects.equals(assetTurnoverRatio, that.assetTurnoverRatio) &&
                Objects.equals(manufacturingCost, that.manufacturingCost) &&
                Objects.equals(itSecurityRating, that.itSecurityRating) &&
                Objects.equals(qualityAssuranceScore, that.qualityAssuranceScore) &&
                Objects.equals(hrComplianceScore, that.hrComplianceScore) &&
                Objects.equals(ecoSustainabilityIndex, that.ecoSustainabilityIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderIdentifier, customerFullName, orderDate, salesStatus, salesDate, itemId, quantity, price, productTitle, productType, customerCategory, discountStatus, discountStartDate, discountEndDate, shipmentId, shippingDate, shippingCost, regionName, salesTerritory, branchId, branchRevenue, employeeId, employeeName, performanceStatus, financialQuarter, annualRevenue, vendorId, vendorName, warehouseId, warehouseCapacity, stockLevel, taxRate, paymentMethod, refundAmount, reviewScore, supplierRating, transactionType, campaignBudget, promotionDiscount, categoryName, contractValue, deliverySuccessRate, coverageAmount, riskCategory, departmentName, budgetAllocated, logisticsEfficiency, insuranceType, financialStabilityIndex, assetTurnoverRatio, manufacturingCost, itSecurityRating, qualityAssuranceScore, hrComplianceScore, ecoSustainabilityIndex);
    }
}