package hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderResponse {
    private UUID id;

    @NotNull
    private Long orderId;

    @Size(max = 100)
    private String customerName;

    @NotNull
    private LocalDateTime orderDate;

    @NotNull
    private String product;

    @NotNull
    private int quantity;

    @NotNull
    private double totalPrice;

    @NotNull
    private BigDecimal totalAmount;

    @JsonProperty("items")
    private List<OrderItemResponse> items = new ArrayList<>();

    public OrderResponse(UUID id, Long orderId, String customerName, LocalDateTime orderDate, String product, int quantity, double totalPrice, BigDecimal totalAmount, List<OrderItemResponse> items) {
        this.id = id;
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.totalAmount = totalAmount;
        this.items = items != null ? items : new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItemResponse> getItems() {
        return items;
    }

    public void setItems(List<OrderItemResponse> items) {
        this.items = items != null ? items : new ArrayList<>();
    }
}