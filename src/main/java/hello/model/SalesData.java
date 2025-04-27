package hello.model;

import java.io.Serializable;

public class SalesData implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String productName;
    private int quantitySold;
    private double totalRevenue;
    private String saleDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        this.productName = productName;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        if (quantitySold < 0) {
            throw new IllegalArgumentException("Quantity sold cannot be negative");
        }
        this.quantitySold = quantitySold;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        if (totalRevenue < 0) {
            throw new IllegalArgumentException("Total revenue cannot be negative");
        }
        this.totalRevenue = totalRevenue;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        if (saleDate == null || saleDate.isEmpty()) {
            throw new IllegalArgumentException("Sale date cannot be null or empty");
        }
        this.saleDate = saleDate;
    }
}