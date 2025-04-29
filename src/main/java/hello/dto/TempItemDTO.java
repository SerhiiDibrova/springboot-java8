package hello.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
public class TempItemDTO {

    private Integer orderId;

    @NotNull
    @Size(max = 50)
    private String customerSegment;

    @NotNull
    @Size(max = 50)
    private String regionName;

    @NotNull
    @Size(max = 50)
    private String productCategory;

    @NotNull
    private BigDecimal salesAmount;

    @NotNull
    private BigDecimal taxRate;

    @NotNull
    private Integer stockLevel;

    @NotNull
    private BigDecimal shippingCost;

    @NotNull
    private Integer warehouseCapacity;

    @NotNull
    private Integer employeePerformance;

    @NotNull
    private BigDecimal logisticsEfficiency;

    @NotNull
    private BigDecimal supplierRating;

    @NotNull
    private BigDecimal itSecurityRating;

    @NotNull
    private BigDecimal refundAmount;

    @NotNull
    private BigDecimal qualityAssuranceScore;

    @NotNull
    private BigDecimal promotionDiscount;

    @NotNull
    private BigDecimal financialStabilityIndex;

    @NotNull
    @Size(max = 50)
    private String riskCategory;

    @NotNull
    private BigDecimal ecoSustainabilityIndex;
}