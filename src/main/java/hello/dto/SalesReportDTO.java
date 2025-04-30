package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesReportDTO {

    @NotNull
    private Integer orderIdentifier;

    private String customerFullName;

    private Date orderDate;

    private String salesStatus;

    private Date salesDate;

    private Integer itemId;

    private Integer quantity;

    private BigDecimal price;

    private String productTitle;

    private String productType;

    private String customerCategory;

    private String discountStatus;

    private Date discountStartDate;

    private Date discountEndDate;

    private Integer shipmentId;

    private Date shippingDate;

    private BigDecimal shippingCost;

    private String regionName;

    private String salesTerritory;

    private Integer branchId;

    private BigDecimal branchRevenue;

    private Integer employeeId;

    private String employeeName;

    private String performanceStatus;

    private String financialQuarter;

    private BigDecimal annualRevenue;

    private Integer vendorId;

    private String vendorName;

    private Integer warehouseId;

    private Integer warehouseCapacity;

    private Integer stockLevel;

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

    private BigDecimal deliverySuccessRate;

    private BigDecimal coverageAmount;

    private String riskCategory;

    private String departmentName;

    private BigDecimal budgetAllocated;

    private BigDecimal logisticsEfficiency;

    private String insuranceType;

    private BigDecimal financialStabilityIndex;

    private BigDecimal assetTurnoverRatio;

    private BigDecimal manufacturingCost;

    private Integer itSecurityRating;

    private Integer qualityAssuranceScore;

    private Integer hrComplianceScore;

    private BigDecimal ecoSustainabilityIndex;

    private Integer managerId;

    private String xmlData;

    private Boolean isAuditNeeded = false;
}