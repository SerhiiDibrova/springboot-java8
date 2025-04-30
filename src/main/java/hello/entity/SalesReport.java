package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "SalesReport")
public class SalesReport {

    @Id
    @Column(name = "order_id", nullable = false)
    @NotNull
    private Integer orderIdentifier;

    @Column(name = "customer_full_name", nullable = false)
    @NotNull
    @Size(max = 255)
    private String customerFullName;

    @Column(name = "order_date", nullable = false)
    @NotNull
    private LocalDate orderDate;

    @Column(name = "sales_status", nullable = false)
    @NotNull
    @Size(max = 50)
    private String salesStatus;

    @Column(name = "sales_date")
    private LocalDate salesDate;

    @Column(name = "item_id", nullable = false)
    @NotNull
    private Integer itemId;

    @Column(name = "quantity", nullable = false)
    @NotNull
    private Integer quantity;

    @Column(name = "price", nullable = false)
    @NotNull
    private BigDecimal price;

    @Column(name = "product_title", nullable = false)
    @NotNull
    @Size(max = 255)
    private String productTitle;

    @Column(name = "product_type", nullable = false)
    @NotNull
    @Size(max = 50)
    private String productType;

    @Column(name = "customer_category", nullable = false)
    @NotNull
    @Size(max = 50)
    private String customerCategory;

    @Column(name = "discount_status", nullable = false)
    @NotNull
    @Size(max = 50)
    private String discountStatus;

    @Column(name = "discount_start_date")
    private LocalDate discountStartDate;

    @Column(name = "discount_end_date")
    private LocalDate discountEndDate;

    @Column(name = "shipment_id")
    private Integer shipmentId;

    @Column(name = "shipping_date")
    private LocalDate shippingDate;

    @Column(name = "shipping_cost")
    private BigDecimal shippingCost;

    @Column(name = "region_name", nullable = false)
    @NotNull
    @Size(max = 100)
    private String regionName;

    @Column(name = "sales_territory", nullable = false)
    @NotNull
    @Size(max = 100)
    private String salesTerritory;

    @Column(name = "branch_id", nullable = false)
    @NotNull
    private Integer branchId;

    @Column(name = "branch_revenue", nullable = false)
    @NotNull
    private BigDecimal branchRevenue;

    @Column(name = "employee_id", nullable = false)
    @NotNull
    private Integer employeeId;

    @Column(name = "employee_name", nullable = false)
    @NotNull
    @Size(max = 255)
    private String employeeName;

    @Column(name = "performance_status", nullable = false)
    @NotNull
    @Size(max = 50)
    private String performanceStatus;

    @Column(name = "financial_quarter")
    private String financialQuarter;

    @Column(name = "annual_revenue")
    private BigDecimal annualRevenue;

    @Column(name = "vendor_id")
    private Integer vendorId;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "warehouse_id", nullable = false)
    @NotNull
    private Integer warehouseId;

    @Column(name = "warehouse_capacity", nullable = false)
    @NotNull
    private Integer warehouseCapacity;

    @Column(name = "stock_level", nullable = false)
    @NotNull
    private Integer stockLevel;

    @Column(name = "tax_rate")
    private BigDecimal taxRate;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "refund_amount")
    private BigDecimal refundAmount;

    @Column(name = "review_score")
    private BigDecimal reviewScore;

    @Column(name = "supplier_rating")
    private BigDecimal supplierRating;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "campaign_budget")
    private BigDecimal campaignBudget;

    @Column(name = "promotion_discount")
    private BigDecimal promotionDiscount;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "contract_value")
    private BigDecimal contractValue;

    @Column(name = "delivery_success_rate")
    private BigDecimal deliverySuccessRate;

    @Column(name = "coverage_amount")
    private BigDecimal coverageAmount;

    @Column(name = "risk_category")
    private String riskCategory;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "budget_allocated")
    private BigDecimal budgetAllocated;

    @Column(name = "logistics_efficiency")
    private BigDecimal logisticsEfficiency;

    @Column(name = "insurance_type")
    private String insuranceType;

    @Column(name = "financial_stability_index")
    private BigDecimal financialStabilityIndex;

    @Column(name = "asset_turnover_ratio")
    private BigDecimal assetTurnoverRatio;

    @Column(name = "manufacturing_cost")
    private BigDecimal manufacturingCost;

    @Column(name = "it_security_rating")
    private Integer itSecurityRating;

    @Column(name = "quality_assurance_score")
    private Integer qualityAssuranceScore;

    @Column(name = "hr_compliance_score")
    private Integer hrComplianceScore;

    @Column(name = "eco_sustainability_index")
    private BigDecimal ecoSustainabilityIndex;

    @ManyToOne
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendor_id", insertable = false, updatable = false)
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id", insertable = false, updatable = false)
    private Branch branch;

    // Getters and Setters
}