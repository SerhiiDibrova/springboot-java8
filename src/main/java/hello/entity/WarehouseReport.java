package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "WarehouseReport")
@Data
public class WarehouseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long warehouseId;

    @NotNull
    @Column
    private String warehouseName;

    @NotNull
    @Column
    private Integer warehouseCapacity;

    @Column
    private Long orderId;

    @Column
    private String regionName;

    @Column
    private String branchName;

    @Column
    private String vendorName;

    @Column
    private String productCategory;

    @Column
    private Integer stockLevel;

    @Column
    private Double logisticsEfficiency;
}