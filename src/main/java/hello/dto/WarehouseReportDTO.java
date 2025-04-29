package hello.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class WarehouseReportDTO {
    @NotNull
    private Long warehouseId;

    @NotNull
    private String warehouseName;

    @NotNull
    private Integer warehouseCapacity;

    private Long orderId;
    private String regionName;
    private String branchName;
    private String vendorName;
    private String productCategory;
    private Integer stockLevel;
    private Double logisticsEfficiency;
}