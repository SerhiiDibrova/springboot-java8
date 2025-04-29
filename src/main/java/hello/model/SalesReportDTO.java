package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesReportDTO {
    
    @NotNull
    @JsonProperty("orderIdentifier")
    private String orderIdentifier = "Unknown";

    @NotNull
    @JsonProperty("customerFullName")
    private String customerFullName = "No Name";

    @NotNull
    @JsonProperty("orderDate")
    private LocalDate orderDate;

    @NotNull
    @JsonProperty("salesStatus")
    private String salesStatus = "Disabled";

    @JsonProperty("salesDate")
    private LocalDate salesDate;

    @NotNull
    @JsonProperty("itemId")
    private Integer itemId;

    @NotNull
    @JsonProperty("quantity")
    private Integer quantity = 0;

    @NotNull
    @JsonProperty("price")
    private BigDecimal price = BigDecimal.ZERO;

    @NotNull
    @JsonProperty("productTitle")
    private String productTitle;

    @NotNull
    @JsonProperty("productType")
    private String productType;

    @JsonProperty("customerCategory")
    private String customerCategory;

    @NotNull
    @JsonProperty("discountStatus")
    private String discountStatus = "Disabled";

    @JsonProperty("discountStartDate")
    private LocalDate discountStartDate;

    @JsonProperty("discountEndDate")
    private LocalDate discountEndDate;

    @JsonProperty("shipmentId")
    private Integer shipmentId;

    @JsonProperty("shippingDate")
    private LocalDate shippingDate;

    @JsonProperty("shippingCost")
    private BigDecimal shippingCost = BigDecimal.ZERO;

    @JsonProperty("regionName")
    private String regionName;

    @JsonProperty("salesTerritory")
    private String salesTerritory;

    @JsonProperty("branchId")
    private Integer branchId;

    @JsonProperty("branchRevenue")
    private BigDecimal branchRevenue = BigDecimal.ZERO;

    @JsonProperty("employeeId")
    private Integer employeeId;

    @JsonProperty("employeeName")
    private String employeeName;

    @NotNull
    @JsonProperty("performanceStatus")
    private String performanceStatus = "Standard";

    @JsonProperty("financialQuarter")
    private String financialQuarter;

    @JsonProperty("annualRevenue")
    private BigDecimal annualRevenue = BigDecimal.ZERO;

    @JsonProperty("vendorId")
    private Integer vendorId;

    @JsonProperty("vendorName")
    private String vendorName;

    @JsonProperty("warehouseId")
    private Integer warehouseId;

    @JsonProperty("warehouseCapacity")
    private Integer warehouseCapacity;

    @JsonProperty("stockLevel")
    private Integer stockLevel = 0;

    @JsonProperty("taxRate")
    private BigDecimal taxRate = BigDecimal.ZERO;

    @JsonProperty("paymentMethod")
    private String paymentMethod;

    @JsonProperty("refundAmount")
    private BigDecimal refundAmount = BigDecimal.ZERO;

    @JsonProperty("reviewScore")
    private Integer reviewScore = 0;

    @JsonProperty("supplierRating")
    private Integer supplierRating = 0;

    @JsonProperty("transactionType")
    private String transactionType;

    @JsonProperty("campaignBudget")
    private BigDecimal campaignBudget = BigDecimal.ZERO;

    @JsonProperty("promotionDiscount")
    private BigDecimal promotionDiscount = BigDecimal.ZERO;

    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("contractValue")
    private BigDecimal contractValue = BigDecimal.ZERO;

    @JsonProperty("deliverySuccessRate")
    private BigDecimal deliverySuccessRate = BigDecimal.ZERO;

    @JsonProperty("coverageAmount")
    private BigDecimal coverageAmount = BigDecimal.ZERO;

    @JsonProperty("insuranceType")
    private String insuranceType;

    @JsonProperty("riskCategory")
    private String riskCategory;

    @JsonProperty("departmentName")
    private String departmentName;

    @JsonProperty("budgetAllocated")
    private BigDecimal budgetAllocated = BigDecimal.ZERO;

    @JsonProperty("financialStabilityIndex")
    private BigDecimal financialStabilityIndex = BigDecimal.ZERO;

    @JsonProperty("assetTurnoverRatio")
    private BigDecimal assetTurnoverRatio = BigDecimal.ZERO;

    @JsonProperty("manufacturingCost")
    private BigDecimal manufacturingCost = BigDecimal.ZERO;

    @JsonProperty("itSecurityRating")
    private Integer itSecurityRating = 0;

    @JsonProperty("qualityAssuranceScore")
    private Integer qualityAssuranceScore = 0;

    @JsonProperty("hrComplianceScore")
    private Integer hrComplianceScore = 0;

    @JsonProperty("ecoSustainabilityIndex")
    private BigDecimal ecoSustainabilityIndex = BigDecimal.ZERO;

    // Getters and Setters
}