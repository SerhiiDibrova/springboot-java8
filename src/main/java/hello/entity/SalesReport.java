package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "SalesReport")
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderIdentifier;

    private String customerFullName;

    private LocalDateTime orderDate;

    private String salesStatus;

    private LocalDateTime salesDate;

    private Long itemId;

    private Integer quantity;

    private BigDecimal price;

    private String productTitle;

    private String productType;

    private String customerCategory;

    private String discountStatus;

    private LocalDateTime discountStartDate;

    private LocalDateTime discountEndDate;

    private Long shipmentId;

    private LocalDateTime shippingDate;

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

    @NotNull
    @Column(nullable = false)
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

    private Double deliverySuccessRate;

    private BigDecimal coverageAmount;

    private String riskCategory;

    private String departmentName;

    private BigDecimal budgetAllocated;

    private Double logisticsEfficiency;

    private String insuranceType;

    private Double financialStabilityIndex;

    private Double assetTurnoverRatio;

    private BigDecimal manufacturingCost;

    private Integer itSecurityRating;

    private Integer qualityAssuranceScore;

    private Integer hrComplianceScore;

    private Double ecoSustainabilityIndex;

    @NotNull
    private String salesData;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    // Getters and Setters
}