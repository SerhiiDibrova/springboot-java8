package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "WarehouseReport")
public class WarehouseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long warehouseId;

    @Column(name = "WarehouseName", nullable = false)
    @NotNull
    private String warehouseName;

    @Column(name = "WarehouseCapacity", nullable = false)
    @NotNull
    private Integer warehouseCapacity;

    @Column(name = "OrderId", nullable = false)
    @NotNull
    private Long orderId;

    @Column(name = "RegionName", nullable = false)
    @NotNull
    private String regionName;

    @Column(name = "BranchName", nullable = false)
    @NotNull
    private String branchName;

    @Column(name = "VendorName", nullable = false)
    @NotNull
    private String vendorName;

    @Column(name = "ProductCategory", nullable = false)
    @NotNull
    private String productCategory;

    @Column(name = "StockLevel", nullable = false)
    @NotNull
    private Integer stockLevel;

    @Column(name = "LogisticsEfficiency", nullable = false)
    @NotNull
    private Double logisticsEfficiency;

    @Column(name = "created_date", nullable = false)
    @NotNull
    private LocalDateTime createdDate;

    @Column(name = "inventory_count", nullable = false)
    @NotNull
    private Integer inventoryCount = 0;
}