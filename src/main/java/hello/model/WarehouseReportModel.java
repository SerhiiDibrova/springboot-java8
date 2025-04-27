package hello.model;

import lombok.Data;

@Data
public class WarehouseReportModel {
    private Long warehouseId;
    private String warehouseName;
    private Integer warehouseCapacity;
    private Long orderId;
    private String regionName;
    private String branchName;
    private String vendorName;
    private String productCategory;
    private Integer stockLevel;
    private Double logisticsEfficiency;
}