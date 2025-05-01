package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "#SalesReport")
public class SalesReport {

    @NotNull
    @Column(name = "Order_Identifier")
    private Long orderIdentifier;

    @NotNull
    @Column(name = "Customer_FullName")
    private String customerFullName;

    @NotNull
    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @NotNull
    @Column(name = "Sales_Status")
    private String salesStatus;

    @NotNull
    @Column(name = "SalesDate")
    private LocalDate salesDate;

    @NotNull
    @Column(name = "ItemId")
    private Integer itemId;

    @NotNull
    @Column(name = "Quantity")
    private Integer quantity;

    @NotNull
    @Column(name = "Price")
    private BigDecimal price;

    @NotNull
    @Column(name = "Product_Title")
    private String productTitle;

    @NotNull
    @Column(name = "Product_Type")
    private String productType;

    @NotNull
    @Column(name = "Customer_Category")
    private String customerCategory;

    @NotNull
    @Column(name = "Discount_Status")
    private String discountStatus;

    @NotNull
    @Column(name = "DiscountStartDate")
    private LocalDate discountStartDate;

    @NotNull
    @Column(name = "DiscountEndDate")
    private LocalDate discountEndDate;

    @NotNull
    @Column(name = "ShipmentId")
    private Integer shipmentId;

    @NotNull
    @Column(name = "ShippingDate")
    private LocalDate shippingDate;

    @NotNull
    @Column(name = "ShippingCost")
    private BigDecimal shippingCost;

    @NotNull
    @Column(name = "RegionName")
    private String regionName;

    @NotNull
    @Column(name = "SalesTerritory")
    private String salesTerritory;

    @NotNull
    @Column(name = "BranchId")
    private Integer branchId;

    @NotNull
    @Column(name = "BranchRevenue")
    private BigDecimal branchRevenue;

    @NotNull
    @Column(name = "EmployeeId")
    private Integer employeeId;

    @NotNull
    @Column(name = "EmployeeName")
    private String employeeName;

    @NotNull
    @Column(name = "Performance_Status")
    private String performanceStatus;

    @NotNull
    @Column(name = "FinancialQuarter")
    private String financialQuarter;

    @NotNull
    @Column(name = "AnnualRevenue")
    private BigDecimal annualRevenue;

    @NotNull
    @Column(name = "VendorId")
    private Integer vendorId;

    @NotNull
    @Column(name = "VendorName")
    private String vendorName;

    @NotNull
    @Column(name = "WarehouseId")
    private Integer warehouseId;

    @NotNull
    @Column(name = "WarehouseCapacity")
    private Integer warehouseCapacity;

    @NotNull
    @Column(name = "StockLevel")
    private Integer stockLevel;

    @NotNull
    @Column(name = "TaxRate")
    private BigDecimal taxRate;

    @NotNull
    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @NotNull
    @Column(name = "RefundAmount")
    private BigDecimal refundAmount;

    @NotNull
    @Column(name = "ReviewScore")
    private Integer reviewScore;

    @NotNull
    @Column(name = "SupplierRating")
    private Integer supplierRating;

    @NotNull
    @Column(name = "TransactionType")
    private String transactionType;

    @NotNull
    @Column(name = "CampaignBudget")
    private BigDecimal campaignBudget;

    @NotNull
    @Column(name = "PromotionDiscount")
    private BigDecimal promotionDiscount;

    @NotNull
    @Column(name = "CategoryName")
    private String categoryName;

    @NotNull
    @Column(name = "ContractValue")
    private BigDecimal contractValue;

    @NotNull
    @Column(name = "DeliverySuccessRate")
    private BigDecimal deliverySuccessRate;

    @NotNull
    @Column(name = "CoverageAmount")
    private BigDecimal coverageAmount;

    @NotNull
    @Column(name = "InsuranceType")
    private String insuranceType;

    @NotNull
    @Column(name = "RiskCategory")
    private String riskCategory;

    @NotNull
    @Column(name = "DepartmentName")
    private String departmentName;

    @NotNull
    @Column(name = "BudgetAllocated")
    private BigDecimal budgetAllocated;

    @NotNull
    @Column(name = "FinancialStabilityIndex")
    private BigDecimal financialStabilityIndex;

    @NotNull
    @Column(name = "AssetTurnoverRatio")
    private BigDecimal assetTurnoverRatio;

    @NotNull
    @Column(name = "ManufacturingCost")
    private BigDecimal manufacturingCost;

    @NotNull
    @Column(name = "ITSecurityRating")
    private Integer itSecurityRating;

    @NotNull
    @Column(name = "QualityAssuranceScore")
    private Integer qualityAssuranceScore;

    @NotNull
    @Column(name = "HRComplianceScore")
    private Integer hrComplianceScore;

    @NotNull
    @Column(name = "EcoSustainabilityIndex")
    private BigDecimal ecoSustainabilityIndex;

    // Getters and Setters
}