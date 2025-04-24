

package hello.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "warehouse_report")
public class WarehouseReportEntity {

    private Long warehouseId;
    private String warehouseName;
    private Integer warehouseCapacity;
    private Long orderId;
    private String regionName;
    private String branchName;
    private String vendorName;
    private String productCategory;
    private Integer stockLevel;
    private BigDecimal logisticsEfficiency;

    public WarehouseReportEntity() {
    }

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

    public BigDecimal getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(BigDecimal logisticsEfficiency) {
        this.logisticsEfficiency = logisticsEfficiency;
    }

    @Override
    public String toString() {
        return "WarehouseReportEntity{" +
                "warehouseId=" + warehouseId +
                ", warehouseName='" + warehouseName + '\'' +
                ", warehouseCapacity=" + warehouseCapacity +
                ", orderId=" + orderId +
                ", regionName='" + regionName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", stockLevel=" + stockLevel +
                ", logisticsEfficiency=" + logisticsEfficiency +
                '}';
    }
}