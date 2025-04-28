package hello.dto;

public class WarehouseReportDTO {
    private Long WarehouseId;
    private String WarehouseName;
    private Integer WarehouseCapacity;
    private Long OrderId;
    private String RegionName;
    private String BranchName;
    private String VendorName;
    private String ProductCategory;
    private Integer StockLevel;
    private Double LogisticsEfficiency;
    private Integer quantity;

    public WarehouseReportDTO() {
    }

    public WarehouseReportDTO(Long WarehouseId, String WarehouseName, Integer WarehouseCapacity, Long OrderId, String RegionName, String BranchName, String VendorName, String ProductCategory, Integer StockLevel, Double LogisticsEfficiency, Integer quantity) {
        this.WarehouseId = WarehouseId;
        this.WarehouseName = WarehouseName;
        this.WarehouseCapacity = WarehouseCapacity;
        this.OrderId = OrderId;
        this.RegionName = RegionName;
        this.BranchName = BranchName;
        this.VendorName = VendorName;
        this.ProductCategory = ProductCategory;
        this.StockLevel = StockLevel;
        this.LogisticsEfficiency = LogisticsEfficiency;
        this.quantity = quantity;
    }

    public Long getWarehouseId() {
        return WarehouseId;
    }

    public void setWarehouseId(Long WarehouseId) {
        this.WarehouseId = WarehouseId;
    }

    public String getWarehouseName() {
        return WarehouseName;
    }

    public void setWarehouseName(String WarehouseName) {
        this.WarehouseName = WarehouseName;
    }

    public Integer getWarehouseCapacity() {
        return WarehouseCapacity;
    }

    public void setWarehouseCapacity(Integer WarehouseCapacity) {
        this.WarehouseCapacity = WarehouseCapacity;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long OrderId) {
        this.OrderId = OrderId;
    }

    public String getRegionName() {
        return RegionName;
    }

    public void setRegionName(String RegionName) {
        this.RegionName = RegionName;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String BranchName) {
        this.BranchName = BranchName;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String VendorName) {
        this.VendorName = VendorName;
    }

    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String ProductCategory) {
        this.ProductCategory = ProductCategory;
    }

    public Integer getStockLevel() {
        return StockLevel;
    }

    public void setStockLevel(Integer StockLevel) {
        this.StockLevel = StockLevel;
    }

    public Double getLogisticsEfficiency() {
        return LogisticsEfficiency;
    }

    public void setLogisticsEfficiency(Double LogisticsEfficiency) {
        this.LogisticsEfficiency = LogisticsEfficiency;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}