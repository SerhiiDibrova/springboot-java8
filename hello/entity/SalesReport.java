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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @NotNull
    @Column(nullable = false)
    private LocalDate reportDate;

    @NotNull
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal totalSales = BigDecimal.ZERO;

    @NotNull
    @Size(max = 255)
    @Column(length = 255)
    private String customerFullName;

    @NotNull
    @Column
    private LocalDate orderDate;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String salesStatus;

    @NotNull
    @Column
    private LocalDate salesDate;

    @NotNull
    @Column
    private Integer itemId;

    @NotNull
    @Column
    private Integer quantity;

    @NotNull
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @NotNull
    @Size(max = 255)
    @Column(length = 255)
    private String productTitle;

    @NotNull
    @Size(max = 100)
    @Column(length = 100)
    private String productType;

    @NotNull
    @Size(max = 100)
    @Column(length = 100)
    private String customerCategory;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String discountStatus;

    @Column
    private LocalDate discountStartDate;

    @Column
    private LocalDate discountEndDate;

    @Column
    private Integer shipmentId;

    @Column
    private LocalDate shippingDate;

    @Column(precision = 10, scale = 2)
    private BigDecimal shippingCost;

    @NotNull
    @Size(max = 100)
    @Column(length = 100)
    private String regionName;

    @NotNull
    @Size(max = 100)
    @Column(length = 100)
    private String salesTerritory;

    @NotNull
    @Column
    private Integer branchId;

    @Column(precision = 10, scale = 2)
    private BigDecimal branchRevenue;

    @NotNull
    @Column
    private Integer employeeId;

    @NotNull
    @Size(max = 255)
    @Column(length = 255)
    private String employeeName;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String performanceStatus;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    private String financialQuarter;

    @Column(precision = 10, scale = 2)
    private BigDecimal annualRevenue;

    @Column
    private Integer vendorId;

    @Size(max = 255)
    @Column(length = 255)
    private String vendorName;

    @Column
    private Integer warehouseId;

    @Column
    private Integer warehouseCapacity;

    @Column
    private Integer stockLevel;

    @Column(precision = 5, scale = 2)
    private BigDecimal taxRate;

    @Size(max = 50)
    @Column(length = 50)
    private String paymentMethod;

    @Column(precision = 10, scale = 2)
    private BigDecimal refundAmount;

    @Column
    private Integer reviewScore;

    @Column
    private Integer supplierRating;

    @Size(max = 50)
    @Column(length = 50)
    private String transactionType;

    @Column(precision = 10, scale = 2)
    private BigDecimal campaignBudget;

    @Column(precision = 10, scale = 2)
    private BigDecimal promotionDiscount;

    @Size(max = 100)
    @Column(length = 100)
    private String categoryName;

    @Column(precision = 10, scale = 2)
    private BigDecimal contractValue;

    @Column(precision = 5, scale = 2)
    private BigDecimal deliverySuccessRate;

    @Column(precision = 10, scale = 2)
    private BigDecimal coverageAmount;

    @Size(max = 100)
    @Column(length = 100)
    private String insuranceType;

    @Size(max = 100)
    @Column(length = 100)
    private String riskCategory;

    @Size(max = 100)
    @Column(length = 100)
    private String departmentName;

    @Column(precision = 10, scale = 2)
    private BigDecimal budgetAllocated;

    @Column(precision = 10, scale = 2)
    private BigDecimal financialStabilityIndex;

    @Column(precision = 10, scale = 2)
    private BigDecimal assetTurnoverRatio;

    @Column(precision = 10, scale = 2)
    private BigDecimal manufacturingCost;

    @Column
    private Integer itSecurityRating;

    @Column
    private Integer qualityAssuranceScore;

    @Column
    private Integer hrComplianceScore;

    @Column
    private Integer ecoSustainabilityIndex;

    // Getters and Setters
}