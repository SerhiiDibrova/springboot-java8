package hello.dto;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class SalesReportDTO {
    @NotNull
    @JsonProperty("orderIdentifier")
    private Long orderIdentifier;

    @NotNull
    @JsonProperty("customerFullName")
    private String customerFullName;

    @NotNull
    @JsonProperty("orderDate")
    private LocalDate orderDate;

    @JsonProperty("salesStatus")
    private String salesStatus;

    @JsonProperty("salesDate")
    private LocalDate salesDate;

    @JsonProperty("itemId")
    private Long itemId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("productTitle")
    private String productTitle;

    @JsonProperty("productType")
    private String productType;

    @JsonProperty("customerCategory")
    private String customerCategory;

    @JsonProperty("discountStatus")
    private String discountStatus;

    @JsonProperty("discountStartDate")
    private LocalDate discountStartDate;

    @JsonProperty("discountEndDate")
    private LocalDate discountEndDate;

    @JsonProperty("shipmentId")
    private Long shipmentId;

    @JsonProperty("shippingDate")
    private LocalDate shippingDate;

    @JsonProperty("shippingCost")
    private BigDecimal shippingCost;

    @JsonProperty("regionName")
    private String regionName;

    @JsonProperty("salesTerritory")
    private String salesTerritory;

    @JsonProperty("branchId")
    private Long branchId;

    @JsonProperty("branchRevenue")
    private BigDecimal branchRevenue;

    @JsonProperty("employeeId")
    private Long employeeId;

    @JsonProperty("employeeName")
    private String employeeName;

    @JsonProperty("performanceStatus")
    private Integer performanceStatus;

    @JsonProperty("financialQuarter")
    private String financialQuarter;

    @JsonProperty("annualRevenue")
    private BigDecimal annualRevenue;

    @JsonProperty("vendorId")
    private Long vendorId;

    @JsonProperty("vendorName")
    private String vendorName;

    @JsonProperty("warehouseId")
    private Long warehouseId;

    @JsonProperty("warehouseCapacity")
    private Integer warehouseCapacity;

    @JsonProperty("stockLevel")
    private Integer stockLevel;

    @JsonProperty("taxRate")
    private BigDecimal taxRate;

    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @JsonProperty("refundAmount")
    private BigDecimal refundAmount;

    @JsonProperty("reviewScore")
    private Integer reviewScore;

    @JsonProperty("supplierRating")
    private Integer supplierRating;

    @JsonProperty("transactionType")
    private String transactionType;

    @JsonProperty("campaignBudget")
    private BigDecimal campaignBudget;

    @JsonProperty("promotionDiscount")
    private BigDecimal promotionDiscount;

    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("contractValue")
    private BigDecimal contractValue;

    @JsonProperty("deliverySuccessRate")
    private BigDecimal deliverySuccessRate;

    @JsonProperty("coverageAmount")
    private BigDecimal coverageAmount;

    @JsonProperty("riskCategory")
    private String riskCategory;

    @JsonProperty("departmentName")
    private String departmentName;

    @JsonProperty("budgetAllocated")
    private BigDecimal budgetAllocated;

    @JsonProperty("logisticsEfficiency")
    private BigDecimal logisticsEfficiency;

    @JsonProperty("insuranceType")
    private String insuranceType;

    @JsonProperty("financialStabilityIndex")
    private BigDecimal financialStabilityIndex;

    @JsonProperty("assetTurnoverRatio")
    private BigDecimal assetTurnoverRatio;

    @JsonProperty("manufacturingCost")
    private BigDecimal manufacturingCost;

    @JsonProperty("itSecurityRating")
    private Integer itSecurityRating;

    @JsonProperty("qualityAssuranceScore")
    private Integer qualityAssuranceScore;

    @JsonProperty("hrComplianceScore")
    private Integer hrComplianceScore;

    @JsonProperty("ecoSustainabilityIndex")
    private BigDecimal ecoSustainabilityIndex;

    public SalesReportDTO() {
    }
}