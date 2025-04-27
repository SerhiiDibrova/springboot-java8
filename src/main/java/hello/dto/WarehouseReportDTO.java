package hello.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseReportDTO {
    private Integer warehouseId;
    private String warehouseName;
    private Integer warehouseCapacity;
    private Integer orderId;
    private String regionName;
    private String branchName;
    private String vendorName;
    private String productCategory;
    private Integer stockLevel;
    private Integer logisticsEfficiency;
    private String reportDate;
    private String reportStatus;
}