package hello.model;

import java.util.Date;
import java.util.UUID;

public class OrderDTO {
    private UUID id;
    private String name;
    private UUID orderId;
    private Date createdAt;
    private String product;
    private int quantity;
    private double price;

    // Constructors
    public OrderDTO() {}

    public OrderDTO(long id, String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public OrderDTO(UUID id, Date createdAt, String product, int quantity, double price) {
        this.id = id;
        this.createdAt = createdAt;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDTO(long id, String name, UUID orderId, Date createdAt, String product, int quantity, double price) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.orderId = orderId;
        this.createdAt = createdAt;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters & Setters
    public UUID getId() { return id; }
    public void setId(long id) { this.id = UUID.randomUUID(); }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public UUID getOrderId() { return orderId; }
    public void setOrderId(UUID orderId) { this.orderId = orderId; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}