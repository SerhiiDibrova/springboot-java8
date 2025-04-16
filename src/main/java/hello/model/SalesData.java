

package hello.model;

import java.time.LocalDate;
import java.util.Objects;

public class SalesData {
    private String region;
    private String country;
    private String itemType;
    private String salesChannel;
    private String orderPriority;
    private LocalDate orderDate;
    private LocalDate shipDate;
    private Integer unitsSold;
    private Double unitPrice;
    private Double totalRevenue;
    private Double totalCost;
    private Double totalProfit;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        if (region == null || region.isEmpty()) {
            throw new IllegalArgumentException("Region cannot be null or empty");
        }
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.isEmpty()) {
            throw new IllegalArgumentException("Country cannot be null or empty");
        }
        this.country = country;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        if (itemType == null || itemType.isEmpty()) {
            throw new IllegalArgumentException("Item type cannot be null or empty");
        }
        this.itemType = itemType;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        if (salesChannel == null || salesChannel.isEmpty()) {
            throw new IllegalArgumentException("Sales channel cannot be null or empty");
        }
        this.salesChannel = salesChannel;
    }

    public String getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        if (orderPriority == null || orderPriority.isEmpty()) {
            throw new IllegalArgumentException("Order priority cannot be null or empty");
        }
        this.orderPriority = orderPriority;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        if (orderDate == null) {
            throw new IllegalArgumentException("Order date cannot be null");
        }
        this.orderDate = orderDate;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDate shipDate) {
        if (shipDate == null) {
            throw new IllegalArgumentException("Ship date cannot be null");
        }
        this.shipDate = shipDate;
    }

    public Integer getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(Integer unitsSold) {
        if (unitsSold == null || unitsSold < 0) {
            throw new IllegalArgumentException("Units sold cannot be null or negative");
        }
        this.unitsSold = unitsSold;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        if (unitPrice == null || unitPrice < 0) {
            throw new IllegalArgumentException("Unit price cannot be null or negative");
        }
        this.unitPrice = unitPrice;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        if (totalRevenue == null || totalRevenue < 0) {
            throw new IllegalArgumentException("Total revenue cannot be null or negative");
        }
        this.totalRevenue = totalRevenue;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        if (totalCost == null || totalCost < 0) {
            throw new IllegalArgumentException("Total cost cannot be null or negative");
        }
        this.totalCost = totalCost;
    }

    public Double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Double totalProfit) {
        if (totalProfit == null || totalProfit < 0) {
            throw new IllegalArgumentException("Total profit cannot be null or negative");
        }
        this.totalProfit = totalProfit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesData salesData = (SalesData) o;
        return Objects.equals(region, salesData.region) &&
                Objects.equals(country, salesData.country) &&
                Objects.equals(itemType, salesData.itemType) &&
                Objects.equals(salesChannel, salesData.salesChannel) &&
                Objects.equals(orderPriority, salesData.orderPriority) &&
                Objects.equals(orderDate, salesData.orderDate) &&
                Objects.equals(shipDate, salesData.shipDate) &&
                Objects.equals(unitsSold, salesData.unitsSold) &&
                Objects.equals(unitPrice, salesData.unitPrice) &&
                Objects.equals(totalRevenue, salesData.totalRevenue) &&
                Objects.equals(totalCost, salesData.totalCost) &&
                Objects.equals(totalProfit, salesData.totalProfit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, country, itemType, salesChannel, orderPriority, orderDate, shipDate, unitsSold, unitPrice, totalRevenue, totalCost, totalProfit);
    }

    @Override
    public String toString() {
        return "SalesData{" +
                "region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", itemType='" + itemType + '\'' +
                ", salesChannel='" + salesChannel + '\'' +
                ", orderPriority='" + orderPriority + '\'' +
                ", orderDate=" + orderDate +
                ", shipDate=" + shipDate +
                ", unitsSold=" + unitsSold +
                ", unitPrice=" + unitPrice +
                ", totalRevenue=" + totalRevenue +
                ", totalCost=" + totalCost +
                ", totalProfit=" + totalProfit +
                '}';
    }
}