package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "WarehouseReport")
public class WarehouseReport implements Serializable {

    @Id
    @NotNull
    @Column(name = "warehouse_id", nullable = false)
    private Long warehouseId;

    @NotNull
    @Column(name = "warehouseName", nullable = false)
    private String warehouseName;

    @NotNull
    @Column(name = "warehouseCapacity", nullable = false)
    private Integer warehouseCapacity;

    @Null
    @Column(name = "order_id", nullable = true)
    private Long orderId;

    @Null
    @Column(name = "regionName", nullable = true)
    private String regionName;

    @Null
    @Column(name = "branchName", nullable = true)
    private String branchName;

    @Null
    @Column(name = "vendorName", nullable = true)
    private String vendorName;

    @Null
    @Column(name = "productCategory", nullable = true)
    private String productCategory;

    @Null
    @Column(name = "stockLevel", nullable = true)
    private Integer stockLevel;

    @Null
    @Column(name = "logisticsEfficiency", nullable = true)
    private Double logisticsEfficiency;

    @NotNull
    @Column(name = "report_date", nullable = false)
    private LocalDate reportDate;

    @NotNull
    @Column(name = "inventory_count", nullable = false)
    private Integer inventoryCount;

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Integer getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(Integer warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    public Double getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(Double logisticsEfficiency) {
        this.logisticsEfficiency = logisticsEfficiency;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public Integer getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Integer inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}