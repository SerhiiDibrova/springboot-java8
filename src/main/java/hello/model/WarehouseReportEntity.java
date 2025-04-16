

package hello.model;

import java.io.Serializable;

public class WarehouseReportEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long warehouseId;
    private String warehouseName;
    private Integer warehouseCapacity;
    private Long orderId;
    private String regionName;
    private String branchName;
    private String vendorName;
    private String productCategory;
    private Integer stockLevel;
    private Double logisticsEfficiency;

    public WarehouseReportEntity() {}

    @ConstructorProperties({"warehouseId", "warehouseName", "warehouseCapacity", "orderId", "regionName", "branchName", "vendorName", "productCategory", "stockLevel", "logisticsEfficiency"})
    public WarehouseReportEntity(Long warehouseId, String warehouseName, Integer warehouseCapacity, Long orderId, String regionName, String branchName, String vendorName, String productCategory, Integer stockLevel, Double logisticsEfficiency) {
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.warehouseCapacity = warehouseCapacity;
        this.orderId = orderId;
        this.regionName = regionName;
        this.branchName = branchName;
        this.vendorName = vendorName;
        this.productCategory = productCategory;
        this.stockLevel = stockLevel;
        this.logisticsEfficiency = logisticsEfficiency;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        if (warehouseId == null) {
            throw new NullPointerException("warehouseId cannot be null");
        }
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        if (warehouseName == null) {
            throw new NullPointerException("warehouseName cannot be null");
        }
        this.warehouseName = warehouseName;
    }

    public Integer getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(Integer warehouseCapacity) {
        if (warehouseCapacity == null) {
            throw new NullPointerException("warehouseCapacity cannot be null");
        }
        this.warehouseCapacity = warehouseCapacity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        if (orderId == null) {
            throw new NullPointerException("orderId cannot be null");
        }
        this.orderId = orderId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        if (regionName == null) {
            throw new NullPointerException("regionName cannot be null");
        }
        this.regionName = regionName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        if (branchName == null) {
            throw new NullPointerException("branchName cannot be null");
        }
        this.branchName = branchName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        if (vendorName == null) {
            throw new NullPointerException("vendorName cannot be null");
        }
        this.vendorName = vendorName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        if (productCategory == null) {
            throw new NullPointerException("productCategory cannot be null");
        }
        this.productCategory = productCategory;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        if (stockLevel == null) {
            throw new NullPointerException("stockLevel cannot be null");
        }
        this.stockLevel = stockLevel;
    }

    public Double getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(Double logisticsEfficiency) {
        if (logisticsEfficiency == null) {
            throw new NullPointerException("logisticsEfficiency cannot be null");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WarehouseReportEntity that = (WarehouseReportEntity) o;

        if (warehouseId != null ? !warehouseId.equals(that.warehouseId) : that.warehouseId != null) return false;
        if (warehouseName != null ? !warehouseName.equals(that.warehouseName) : that.warehouseName != null) return false;
        if (warehouseCapacity != null ? !warehouseCapacity.equals(that.warehouseCapacity) : that.warehouseCapacity != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (regionName != null ? !regionName.equals(that.regionName) : that.regionName != null) return false;
        if (branchName != null ? !branchName.equals(that.branchName) : that.branchName != null) return false;
        if (vendorName != null ? !vendorName.equals(that.vendorName) : that.vendorName != null) return false;
        if (productCategory != null ? !productCategory.equals(that.productCategory) : that.productCategory != null) return false;
        if (stockLevel != null ? !stockLevel.equals(that.stockLevel) : that.stockLevel != null) return false;
        return logisticsEfficiency != null ? logisticsEfficiency.equals(that.logisticsEfficiency) : that.logisticsEfficiency == null;
    }

    @Override
    public int hashCode() {
        int result = warehouseId != null ? warehouseId.hashCode() : 0;
        result = 31 * result + (warehouseName != null ? warehouseName.hashCode() : 0);
        result = 31 * result + (warehouseCapacity != null ? warehouseCapacity.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (branchName != null ? branchName.hashCode() : 0);
        result = 31 * result + (vendorName != null ? vendorName.hashCode() : 0);
        result = 31 * result + (productCategory != null ? productCategory.hashCode() : 0);
        result = 31 * result + (stockLevel != null ? stockLevel.hashCode() : 0);
        result = 31 * result + (logisticsEfficiency != null ? logisticsEfficiency.hashCode() : 0);
        return result;
    }
}