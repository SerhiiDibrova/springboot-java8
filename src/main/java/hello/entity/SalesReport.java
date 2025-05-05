package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "#SalesReport")
public class SalesReport {

    @Id
    @Column(nullable = false)
    private Integer orderId;

    @Column(nullable = false)
    private Integer customerId;

    @Column(nullable = false)
    private Integer productId;

    @Column(nullable = false)
    @DecimalMin(value = "0.00")
    private BigDecimal salesAmount;

    @Column
    @DecimalMin(value = "0.00")
    private BigDecimal discountAmount;

    @Column
    @DecimalMin(value = "0.00")
    private BigDecimal shippingCost;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "Order_Identifier", nullable = false)
    private String orderIdentifier;

    @Column(name = "Customer_FullName", nullable = false)
    private String customerFullName;

    @Column(name = "OrderDate")
    private Date orderDate;

    @Column(name = "Sales_Status")
    private String salesStatus;

    @Column(name = "SalesDate")
    private Date salesDate;

    @Column(name = "ItemId")
    private Integer itemId;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Price", precision = 10, scale = 2)
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
    private Date discountStartDate;

    @Column(name = "DiscountEndDate")
    private Date discountEndDate;

    @Column(name = "ShipmentId")
    private Integer shipmentId;

    @Column(name = "ShippingDate")
    private Date shippingDate;

    @Column(name = "ShippingCost", precision = 10, scale = 2)
    private BigDecimal shippingCostValue;

    @Column(name = "RegionName")
    private String regionName;

    @Column(name = "SalesTerritory")
    private String salesTerritory;

    @Column(name = "BranchId")
    private Integer branchId;

    @Column(name = "BranchRevenue", precision = 10, scale = 2)
    private BigDecimal branchRevenue;

    @Column(name = "EmployeeId")
    private Integer employeeId;

    @Column(name = "EmployeeName")
    private String employeeName;

    @Column(name = "Performance_Status")
    private String performanceStatus;

    @Column(name = "FinancialQuarter")
    private String financialQuarter;

    @Column(name = "AnnualRevenue", precision = 10, scale = 2)
    private BigDecimal annualRevenue;

    @Column(name = "VendorId")
    private Integer vendorId;

    @Column(name = "VendorName")
    private String vendorName;

    @Column(name = "WarehouseId")
    private Integer warehouseId;

    @Column(name = "WarehouseCapacity")
    private Integer warehouseCapacity;

    @Column(name = "StockLevel")
    private Integer stockLevel;

    @Column(name = "TaxRate", precision = 5, scale = 2)
    private BigDecimal taxRate;

    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @Column(name = "RefundAmount", precision = 10, scale = 2)
    private BigDecimal refundAmount;

    @Column(name = "ReviewScore")
    private Integer reviewScore;

    @Column(name = "SupplierRating", precision = 5, scale = 2)
    private BigDecimal supplierRating;

    @Column(name = "TransactionType")
    private String transactionType;

    @Column(name = "CampaignBudget", precision = 10, scale = 2)
    private BigDecimal campaignBudget;

    @Column(name = "PromotionDiscount", precision = 10, scale = 2)
    private BigDecimal promotionDiscount;

    @Column(name = "CategoryName")
    private String categoryName;

    @Column(name = "ContractValue", precision = 10, scale = 2)
    private BigDecimal contractValue;

    @Column(name = "DeliverySuccessRate", precision = 5, scale = 2)
    private BigDecimal deliverySuccessRate;

    @Column(name = "CoverageAmount", precision = 10, scale = 2)
    private BigDecimal coverageAmount;

    @Column(name = "RiskCategory")
    private String riskCategory;

    @Column(name = "DepartmentName")
    private String departmentName;

    @Column(name = "BudgetAllocated", precision = 10, scale = 2)
    private BigDecimal budgetAllocated;

    @Column(name = "LogisticsEfficiency", precision = 5, scale = 2)
    private BigDecimal logisticsEfficiency;

    @Column(name = "InsuranceType")
    private String insuranceType;

    @Column(name = "FinancialStabilityIndex", precision = 10, scale = 2)
    private BigDecimal financialStabilityIndex;

    @Column(name = "AssetTurnoverRatio", precision = 10, scale = 2)
    private BigDecimal assetTurnoverRatio;

    @Column(name = "ManufacturingCost", precision = 10, scale = 2)
    private BigDecimal manufacturingCost;

    @Column(name = "ITSecurityRating", precision = 5, scale = 2)
    private BigDecimal itSecurityRating;

    @Column(name = "QualityAssuranceScore", precision = 5, scale = 2)
    private BigDecimal qualityAssuranceScore;

    @Column(name = "HRComplianceScore", precision = 5, scale = 2)
    private BigDecimal hrComplianceScore;

    @Column(name = "EcoSustainabilityIndex", precision = 5, scale = 2)
    private BigDecimal ecoSustainabilityIndex;

    // Getters and Setters
}