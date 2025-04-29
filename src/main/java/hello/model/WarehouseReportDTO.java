package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class WarehouseReportDTO {
    
    @NotNull
    @JsonProperty("warehouseId")
    private Long warehouseId;

    @NotNull
    @Size(max = 255)
    @JsonProperty("warehouseName")
    private String warehouseName;

    @NotNull
    @JsonProperty("warehouseCapacity")
    private Integer warehouseCapacity;

    @JsonProperty("orderId")
    private Long orderId;

    @Size(max = 100)
    @JsonProperty("regionName")
    private String regionName;

    @NotNull
    @JsonProperty("branchName")
    private String branchName;

    @NotNull
    @JsonProperty("vendorName")
    private String vendorName;

    @NotNull
    @Size(max = 50)
    @JsonProperty("productCategory")
    private String productCategory;

    @NotNull
    @JsonProperty("stockLevel")
    private Integer stockLevel;

    @JsonProperty("logisticsEfficiency")
    private BigDecimal logisticsEfficiency;
}