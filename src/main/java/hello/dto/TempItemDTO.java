package hello.dto;

import java.util.Objects;

public class TempItemDTO {
    private String orderId;
    private String regionName;
    private String productCategory;
    private int stockLevel;
    private double logisticsEfficiency;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or empty");
        }
        this.orderId = orderId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        if (regionName == null || regionName.isEmpty()) {
            throw new IllegalArgumentException("Region name cannot be null or empty");
        }
        this.regionName = regionName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        if (productCategory == null || productCategory.isEmpty()) {
            throw new IllegalArgumentException("Product category cannot be null or empty");
        }
        this.productCategory = productCategory;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        if (stockLevel < 0) {
            throw new IllegalArgumentException("Stock level cannot be negative");
        }
        this.stockLevel = stockLevel;
    }

    public double getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(double logisticsEfficiency) {
        if (logisticsEfficiency < 0) {
            throw new IllegalArgumentException("Logistics efficiency cannot be negative");
        }
        this.logisticsEfficiency = logisticsEfficiency;
    }

    public void filterData(WarehouseReportService service) {
        service.filterTempItems(this);
    }
}