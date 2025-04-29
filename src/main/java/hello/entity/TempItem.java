package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TempItems")
public class TempItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Integer orderId;

    @NotNull
    @Column(nullable = false)
    private String customerSegment;

    @NotNull
    @Column(nullable = false)
    private String regionName;

    @NotNull
    @Column(nullable = false)
    private String productCategory;

    @NotNull
    @Column(nullable = false)
    private BigDecimal salesAmount;

    @NotNull
    @Column(nullable = false)
    private BigDecimal taxRate;

    @NotNull
    @Column(nullable = false)
    private Integer stockLevel;

    @NotNull
    @Column(nullable = false)
    private BigDecimal shippingCost;

    @NotNull
    @Column(nullable = false)
    private Integer warehouseCapacity;

    @NotNull
    @Column(nullable = false)
    private Integer employeePerformance;

    @NotNull
    @Column(nullable = false)
    private BigDecimal logisticsEfficiency;

    @NotNull
    @Column(nullable = false)
    private BigDecimal supplierRating;

    @NotNull
    @Column(nullable = false)
    private BigDecimal itSecurityRating;

    @NotNull
    @Column(nullable = false)
    private BigDecimal refundAmount;

    @NotNull
    @Column(nullable = false)
    private BigDecimal qualityAssuranceScore;

    @NotNull
    @Column(nullable = false)
    private BigDecimal promotionDiscount;

    @NotNull
    @Column(nullable = false)
    private BigDecimal financialStabilityIndex;

    @NotNull
    @Column(nullable = false)
    private String riskCategory;

    @NotNull
    @Column(nullable = false)
    private BigDecimal ecoSustainabilityIndex;

    @NotNull
    @Column(name = "audit_id", nullable = false)
    private Integer auditId;

    @NotNull
    @Column(name = "record_details", length = 255, nullable = false)
    private String recordDetails;

    @NotNull
    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    // Getters and Setters
}