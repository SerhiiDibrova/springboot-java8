package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "SalesReport", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"orderIdentifier", "itemId"})
})
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    private String orderIdentifier;

    @NotNull
    @Column(name = "order_id")
    private Integer orderId;

    @Size(max = 255)
    private String customerFullName;

    @Column(name = "manager_id")
    private Integer managerId;

    private LocalDate orderDate;

    private String salesStatus;

    private LocalDate salesDate;

    private Integer itemId;

    private Integer quantity;

    @NotNull
    @Column(name = "sales_amount")
    private BigDecimal salesAmount = BigDecimal.ZERO;

    private BigDecimal price;

    @Size(max = 255)
    private String productTitle;

    @Size(max = 255)
    private String productType;

    @Size(max = 255)
    private String customerCategory;

    @Size(max = 255)
    private String discountStatus;

    private LocalDate discountStartDate;

    private LocalDate discountEndDate;

    private Integer shipmentId;

    private LocalDate shippingDate;

    private BigDecimal shippingCost;

    @Size(max = 255)
    private String regionName;

    @Size(max = 255)
    private String salesTerritory;

    private Integer branchId;

    private BigDecimal branchRevenue;

    private Integer employeeId;

    @Size(max = 255)
    private String employeeName;

    @Size(max = 255)
    private String performanceStatus;

    @Size(max = 255)
    private String financialQuarter;

    private BigDecimal annualRevenue;

    private Integer vendorId;

    @Size(max = 255)
    private String vendorName;

    private Integer warehouseId;

    private Integer warehouseCapacity;

    private Integer stockLevel;

    private BigDecimal taxRate;

    @Size(max = 255)
    private String paymentMethod;

    private BigDecimal refundAmount;

    private BigDecimal reviewScore;

    private BigDecimal supplierRating;

    @Size(max = 255)
    private String transactionType;

    private BigDecimal campaignBudget;

    private BigDecimal promotionDiscount;

    @Size(max = 255)
    private String categoryName;

    private BigDecimal contractValue;

    private BigDecimal deliverySuccessRate;

    private BigDecimal coverageAmount;

    @Size(max = 255)
    private String riskCategory;

    @Size(max = 255)
    private String departmentName;

    private BigDecimal budgetAllocated;

    private BigDecimal logisticsEfficiency;

    @Size(max = 255)
    private String insuranceType;

    private BigDecimal financialStabilityIndex;

    private BigDecimal assetTurnoverRatio;

    private BigDecimal manufacturingCost;

    private BigDecimal itSecurityRating;

    private BigDecimal qualityAssuranceScore;

    private BigDecimal hrComplianceScore;

    private BigDecimal ecoSustainabilityIndex;

    // Getters and Setters
}