package hello.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class SalesReportDTO {
    @NotNull
    private String orderId;
    
    @NotNull
    private String productName;
    
    @NotNull
    @Positive
    private int quantity;
    
    @NotNull
    @Positive
    private double price;
    
    @NotNull
    private String customerName;

    public SalesReportDTO() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}