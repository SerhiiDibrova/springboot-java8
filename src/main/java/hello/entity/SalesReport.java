package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "SalesReport", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Order_Identifier"}),
    @UniqueConstraint(columnNames = {"ItemId"})
})
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @NotNull
    @Column(name = "Order_Identifier")
    private String Order_Identifier;

    @NotNull
    @Column(name = "Customer_FullName")
    private String Customer_FullName;

    @NotNull
    @Column(name = "OrderDate")
    private LocalDate OrderDate;

    @NotNull
    @Column(name = "Sales_Status")
    private String Sales_Status;

    @NotNull
    @Column(name = "SalesDate")
    private LocalDate SalesDate;

    @NotNull
    @Column(name = "ItemId")
    private Long ItemId;

    @NotNull
    @Column(name = "Quantity")
    private Integer Quantity;

    @NotNull
    @Column(name = "Price")
    private BigDecimal Price;

    @NotNull
    @Column(name = "Product_Title")
    private String Product_Title;

    @NotNull
    @Column(name = "Product_Type")
    private String Product_Type;

    @NotNull
    @Column(name = "Customer_Category")
    private String Customer_Category;

    @NotNull
    @Column(name = "Discount_Status")
    private String Discount_Status;

    @NotNull
    @Column(name = "ShipmentId")
    private Long ShipmentId;

    @NotNull
    @Column(name = "ShippingDate")
    private LocalDate ShippingDate;

    @NotNull
    @Column(name = "ShippingCost")
    private BigDecimal ShippingCost;

    @NotNull
    @Column(name = "RegionName")
    private String RegionName;

    @NotNull
    @Column(name = "BranchId")
    private Long BranchId;

    @NotNull
    @Column(name = "EmployeeId")
    private Long EmployeeId;

    @NotNull
    @Column(name = "Performance_Status")
    private String Performance_Status;

    @NotNull
    @Column(name = "FinancialQuarter")
    private String FinancialQuarter;

    @NotNull
    @Column(name = "AnnualRevenue")
    private BigDecimal AnnualRevenue;

    @NotNull
    @Column(name = "VendorId")
    private Long VendorId;

    @NotNull
    @Column(name = "VendorName")
    private String VendorName;

    @NotNull
    @Column(name = "StockLevel")
    private Integer StockLevel;

    @NotNull
    @Column(name = "TaxRate")
    private BigDecimal TaxRate;

    @NotNull
    @Column(name = "PaymentMethod")
    private String PaymentMethod;

    @NotNull
    @Column(name = "RefundAmount")
    private BigDecimal RefundAmount;

    @NotNull
    @Column(name = "ReviewScore")
    private Integer ReviewScore;

    @NotNull
    @Column(name = "SupplierRating")
    private Integer SupplierRating;

    @NotNull
    @Column(name = "TransactionType")
    private String TransactionType;

    @NotNull
    @Column(name = "CampaignBudget")
    private BigDecimal CampaignBudget;

    @NotNull
    @Column(name = "PromotionDiscount")
    private BigDecimal PromotionDiscount;

    @NotNull
    @Column(name = "CategoryName")
    private String CategoryName;

    @NotNull
    @Column(name = "ContractValue")
    private BigDecimal ContractValue;

    @NotNull
    @Column(name = "DeliverySuccessRate")
    private BigDecimal DeliverySuccessRate;

    @NotNull
    @Column(name = "CoverageAmount")
    private BigDecimal CoverageAmount;

    @NotNull
    @Column(name = "InsuranceType")
    private String InsuranceType;

    @NotNull
    @Column(name = "RiskCategory")
    private String RiskCategory;

    @NotNull
    @Column(name = "DepartmentName")
    private String DepartmentName;

    @NotNull
    @Column(name = "BudgetAllocated")
    private BigDecimal BudgetAllocated;

    @NotNull
    @Column(name = "FinancialStabilityIndex")
    private BigDecimal FinancialStabilityIndex;

    @NotNull
    @Column(name = "AssetTurnoverRatio")
    private BigDecimal AssetTurnoverRatio;

    @NotNull
    @Column(name = "ManufacturingCost")
    private BigDecimal ManufacturingCost;

    @NotNull
    @Column(name = "ITSecurityRating")
    private String ITSecurityRating;

    @NotNull
    @Column(name = "QualityAssuranceScore")
    private Integer QualityAssuranceScore;

    @NotNull
    @Column(name = "HRComplianceScore")
    private Integer HRComplianceScore;

    @NotNull
    @Column(name = "EcoSustainabilityIndex")
    private BigDecimal EcoSustainabilityIndex;

    // Getters and Setters
}