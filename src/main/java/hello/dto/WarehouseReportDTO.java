

package hello.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseReportDTO {
    private Long warehouseId;
    private String warehouseName;
    private Long warehouseCapacity;
    private Long orderId;
    private String regionName;
    private String branchName;
    private String vendorName;
    private String productCategory;
    private Long stockLevel;
    private Long logisticsEfficiency;
}