package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class WarehouseReportDTO {
    @NotNull
    @JsonProperty("warehouseId")
    private Long warehouseId;

    @NotNull
    @Size(min = 1, max = 255)
    @JsonProperty("warehouseName")
    private String warehouseName;

    @NotNull
    @JsonProperty("warehouseCapacity")
    private Integer warehouseCapacity;

    @JsonProperty("orderId")
    private Long orderId;

    @NotNull
    @Size(min = 1, max = 255)
    @JsonProperty("regionName")
    private String regionName;

    @NotNull
    @Size(min = 1, max = 255)
    @JsonProperty("branchName")
    private String branchName;

    @NotNull
    @Size(min = 1, max = 255)
    @JsonProperty("vendorName")
    private String vendorName;

    @NotNull
    @Size(min = 1, max = 255)
    @JsonProperty("productCategory")
    private String productCategory;

    @NotNull
    @JsonProperty("stockLevel")
    private Integer stockLevel;

    @NotNull
    @JsonProperty("logisticsEfficiency")
    private BigDecimal logisticsEfficiency;
}