package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class WarehouseReportDTO implements Serializable {
    
    @NotNull
    private Integer warehouseId;

    @NotNull
    private String warehouseName;

    @NotNull
    private Integer warehouseCapacity;

    @NotNull
    private Integer orderId;

    @NotNull
    private String regionName;

    @NotNull
    private String branchName;

    @NotNull
    private String vendorName;

    @NotNull
    private String productCategory;

    @NotNull
    private Integer stockLevel;

    @NotNull
    private BigDecimal logisticsEfficiency;

    @NotNull
    private String itemName;

    @NotNull
    private Integer quantity;

    @NotNull
    private String warehouseIdString;

    public WarehouseReportDTO() {
        this.itemName = "";
    }
}