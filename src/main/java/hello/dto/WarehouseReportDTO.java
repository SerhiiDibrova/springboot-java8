package hello.dto;

public class WarehouseReportDTO {
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

    public WarehouseReportDTO() {
    }

    public WarehouseReportDTO(Long warehouseId, String warehouseName, Integer warehouseCapacity, Long orderId, String regionName, String branchName, String vendorName, String productCategory, Integer stockLevel, Double logisticsEfficiency) {
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