package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "WarehouseReport")
public class WarehouseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer warehouseId;

    @NotNull
    @Column(nullable = false)
    private String warehouseName;

    @NotNull
    @Column(nullable = false)
    private Integer warehouseCapacity;

    @Column
    private Integer orderId;

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

    @Size(max = 255)
    @Column
    private String logisticsMetric;

    @NotNull
    @Column(nullable = false)
    private String warehouseData;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
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

    public String getLogisticsMetric() {
        return logisticsMetric;
    }

    public void setLogisticsMetric(String logisticsMetric) {
        this.logisticsMetric = logisticsMetric;
    }

    public String getWarehouseData() {
        return warehouseData;
    }

    public void setWarehouseData(String warehouseData) {
        this.warehouseData = warehouseData;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}