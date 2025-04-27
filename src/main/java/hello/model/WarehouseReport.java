package hello.model;

import lombok.Data;

@Data
public class WarehouseReport {
    private String warehouseId;
    private String warehouseName;
    private int warehouseCapacity;
    private String orderId;
    private String regionName;
    private String branchName;
    private String vendorName;
    private String productCategory;
    private int stockLevel;
    private double logisticsEfficiency;
}