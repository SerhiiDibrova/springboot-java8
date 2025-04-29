package hello.dto;

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
    @Size(min = 1, max = 255)
    @JsonProperty("warehouseName")
    private String warehouseName;

    @NotNull
    @JsonProperty("warehouseCapacity")
    private Integer warehouseCapacity;

    @JsonProperty("orderId")
    private Long orderId;

    @JsonProperty("regionName")
    private String regionName;

    @JsonProperty("branchName")
    private String branchName;

    @JsonProperty("vendorName")
    private String vendorName;

    @JsonProperty("productCategory")
    private String productCategory;

    @JsonProperty("stockLevel")
    private Integer stockLevel;

    @JsonProperty("logisticsEfficiency")
    private BigDecimal logisticsEfficiency;

    public static WarehouseReportDTO fromEntity(WarehouseReport entity) {
        WarehouseReportDTO dto = new WarehouseReportDTO();
        dto.setWarehouseId(entity.getWarehouseId());
        dto.setWarehouseName(entity.getWarehouseName());
        dto.setWarehouseCapacity(entity.getWarehouseCapacity());
        dto.setOrderId(entity.getOrderId());
        dto.setRegionName(entity.getRegionName());
        dto.setBranchName(entity.getBranchName());
        dto.setVendorName(entity.getVendorName());
        dto.setProductCategory(entity.getProductCategory());
        dto.setStockLevel(entity.getStockLevel());
        dto.setLogisticsEfficiency(entity.getLogisticsEfficiency());
        return dto;
    }
}