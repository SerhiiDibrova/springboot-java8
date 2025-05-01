package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "#WarehouseReport")
public class WarehouseReport {

    @Id
    @Column(name = "WarehouseId", nullable = false)
    @NotNull
    private Long warehouseId;

    @Column(name = "WarehouseName", nullable = false)
    @NotNull
    @Size(max = 255)
    private String warehouseName;

    @Column(name = "WarehouseCapacity", nullable = false)
    @NotNull
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
}