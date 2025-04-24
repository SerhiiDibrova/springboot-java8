

package hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sales_data")
public class SalesDataEntity {

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "sales_amount")
    private Double salesAmount;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "sales_status")
    private String salesStatus;

    @Column(name = "sales_date")
    private String salesDate;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "customer_category")
    private String customerCategory;

    @Column(name = "discount_status")
    private String discountStatus;

    @Column(name = "discount_start_date")
    private String discountStartDate;

    @Column(name = "discount_end_date")
    private String discountEndDate;

    @Column(name = "shipment_id")
    private Long shipmentId;

    @Column(name = "shipping_date")
    private String shippingDate;

    @Column(name = "shipping_cost")
    private Double shippingCost;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "sales_territory")
    private String salesTerritory;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "branch_revenue")
    private Double branchRevenue;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "performance_status")
    private String performanceStatus;

    @Column(name = "financial_quarter")
    private String financialQuarter;

    @Column(name = "annual_revenue")
    private Double annualRevenue;

    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "warehouse_capacity")
    private Double warehouseCapacity;

    @Column(name = "stock_level")
    private Integer stockLevel;

    @Column(name = "tax_rate")
    private Double taxRate;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "refund_amount")
    private Double refundAmount;

    @Column(name = "review_score")
    private Double reviewScore;

    @Column(name = "supplier_rating")
    private Double supplierRating;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "campaign_budget")
    private Double campaignBudget;

    @Column(name = "promotion_discount")
    private Double promotionDiscount;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "contract_value")
    private Double contractValue;

    @Column(name = "delivery_success_rate")
    private Double deliverySuccessRate;

    @Column(name = "coverage_amount")
    private Double coverageAmount;

    @Column(name = "risk_category")
    private String riskCategory;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "budget_allocated")
    private Double budgetAllocated;

    @Column(name = "logistics_efficiency")
    private Double logisticsEfficiency;

    @Column(name = "insurance_type")
    private String insuranceType;

    @Column(name = "financial_stability_index")
    private Double financialStabilityIndex;

    @Column(name = "asset_turnover_ratio")
    private Double assetTurnoverRatio;

    @Column(name = "manufacturing_cost")
    private Double manufacturingCost;

    @Column(name = "it_security_rating")
    private Double itSecurityRating;

    @Column(name = "quality_assurance_score")
    private Double qualityAssuranceScore;

    @Column(name = "hr_compliance_score")
    private Double hrComplianceScore;

    @Column(name = "eco_sustainability_index")
    private Double ecoSustainabilityIndex;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public String getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(String discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public String getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(String discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
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

    public Double getBranchRevenue() {
        return branchRevenue;
    }

    public void setBranchRevenue(Double branchRevenue) {
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

    public Double getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(Double annualRevenue) {
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

    public Double getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(Double warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Double getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(Double reviewScore) {
        this.reviewScore = reviewScore;
    }

    public Double getSupplierRating() {
        return supplierRating;
    }

    public void setSupplierRating(Double supplierRating) {
        this.supplierRating = supplierRating;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getCampaignBudget() {
        return campaignBudget;
    }

    public void setCampaignBudget(Double campaignBudget) {
        this.campaignBudget = campaignBudget;
    }

    public Double getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(Double promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getContractValue() {
        return contractValue;
    }

    public void setContractValue(Double contractValue) {
        this.contractValue = contractValue;
    }

    public Double getDeliverySuccessRate() {
        return deliverySuccessRate;
    }

    public void setDeliverySuccessRate(Double deliverySuccessRate) {
        this.deliverySuccessRate = deliverySuccessRate;
    }

    public Double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(Double coverageAmount) {
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

    public Double getBudgetAllocated() {
        return budgetAllocated;
    }

    public void setBudgetAllocated(Double budgetAllocated) {
        this.budgetAllocated = budgetAllocated;
    }

    public Double getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(Double logisticsEfficiency) {
        this.logisticsEfficiency = logisticsEfficiency;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Double getFinancialStabilityIndex() {
        return financialStabilityIndex;
    }

    public void setFinancialStabilityIndex(Double financialStabilityIndex) {
        this.financialStabilityIndex = financialStabilityIndex;
    }

    public Double getAssetTurnoverRatio() {
        return assetTurnoverRatio;
    }

    public void setAssetTurnoverRatio(Double assetTurnoverRatio) {
        this.assetTurnoverRatio = assetTurnoverRatio;
    }

    public Double getManufacturingCost() {
        return manufacturingCost;
    }

    public void setManufacturingCost(Double manufacturingCost) {
        this.manufacturingCost = manufacturingCost;
    }

    public Double getItSecurityRating() {
        return itSecurityRating;
    }

    public void setItSecurityRating(Double itSecurityRating) {
        this.itSecurityRating = itSecurityRating;
    }

    public Double getQualityAssuranceScore() {
        return qualityAssuranceScore;
    }

    public void setQualityAssuranceScore(Double qualityAssuranceScore) {
        this.qualityAssuranceScore = qualityAssuranceScore;
    }

    public Double getHrComplianceScore() {
        return hrComplianceScore;
    }

    public void setHrComplianceScore(Double hrComplianceScore) {
        this.hrComplianceScore = hrComplianceScore;
    }

    public Double getEcoSustainabilityIndex() {
        return ecoSustainabilityIndex;
    }

    public void setEcoSustainabilityIndex(Double ecoSustainabilityIndex) {
        this.ecoSustainabilityIndex = ecoSustainabilityIndex;
    }
}