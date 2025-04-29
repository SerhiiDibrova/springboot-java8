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
    
    @NotNull
    private Long orderId;
    
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
    private Double logisticsEfficiency;
}