package hello.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "#SalesReport")
public class SalesReportDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long orderId;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private Long productId;

    @Column(name = "total_sales", nullable = false)
    private BigDecimal totalAmount = BigDecimal.ZERO;

    @Column(name = "report_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "Sales_Status", nullable = false)
    private String status = "Pending";

    @Column(name = "manager_id")
    private Integer managerId;

    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "SalesDate")
    private LocalDate salesDate;

    @Column(name = "ItemId")
    private Integer itemId;

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
    private Integer shipmentId;

    @Column(name = "ShippingDate")
    private LocalDate shippingDate;

    @Column(name = "ShippingCost")
    private BigDecimal shippingCost;

    @Column(name = "RegionName")
    private String regionName;

    @Column(name = "SalesTerritory")
    private String salesTerritory;

    @Column(name = "BranchId")
    private Integer branchId;

    @Column(name = "BranchRevenue")
    private BigDecimal branchRevenue;

    @Column(name = "EmployeeId")
    private Integer employeeId;

    @Column(name = "EmployeeName")
    private String employeeName;

    @Column(name = "Performance_Status")
    private String performanceStatus;

    @Column(name = "FinancialQuarter")
    private String financialQuarter;

    @Column(name = "AnnualRevenue")
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

    @Column(name = "TaxRate")
    private BigDecimal taxRate;

    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @Column(name = "RefundAmount")
    private BigDecimal refundAmount;

    @Column(name = "ReviewScore")
    private Integer reviewScore;

    @Column(name = "SupplierRating")
    private BigDecimal supplierRating;

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

    @Column(name = "RiskCategory")
    private String riskCategory;

    @Column(name = "DepartmentName")
    private String departmentName;

    @Column(name = "BudgetAllocated")
    private BigDecimal budgetAllocated;

    @Column(name = "LogisticsEfficiency")
    private BigDecimal logisticsEfficiency;

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

    // Getters and Setters
}