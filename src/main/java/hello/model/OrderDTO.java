package hello.model;

import java.util.List;
import java.time.LocalDateTime;

public class OrderDTO {
    private String id;
    private String userEmail;
    private List<String> productIds;
    private String customerId;
    private Integer quantity;
    private String status;
    private LocalDateTime createdAt;

    // Constructors
    public OrderDTO() {}

    public OrderDTO(String id, String userEmail, List<String> productIds, String customerId, Integer quantity, String status, LocalDateTime createdAt) {
        this.id = id;
        this.userEmail = userEmail;
        this.productIds = productIds;
        this.customerId = customerId;
        this.quantity = quantity;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public List<String> getProductIds() { return productIds; }
    public void setProductIds(List<String> productIds) { this.productIds = productIds; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}