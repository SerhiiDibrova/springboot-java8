package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "WarehouseReport")
@Getter
@Setter
public class WarehouseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseId;

    @Column(name = "WarehouseName")
    private String warehouseName;

    @Column(name = "WarehouseCapacity")
    private Integer warehouseCapacity;

    @Column(name = "OrderId")
    private Long orderId;

    @Column(name = "RegionName")
    private String regionName;

    @Column(name = "BranchName")
    private String branchName;

    @Column(name = "VendorName")
    private String vendorName;

    @Column(name = "ProductCategory")
    private String productCategory;

    @Column(name = "StockLevel")
    private Integer stockLevel;

    @Column(name = "LogisticsEfficiency")
    private Double logisticsEfficiency;
}