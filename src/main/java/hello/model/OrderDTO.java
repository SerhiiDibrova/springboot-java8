package hello.model;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;

public class OrderDTO {
    private long id;
    private String name;
    private String userEmail;
    private List<String> productIds;

    public OrderDTO() {}

    public OrderDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public OrderDTO(long id, String name, String userEmail, List<String> productIds) {
        this.id = id;
        this.name = name;
        this.userEmail = userEmail;
        this.productIds = productIds;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public List<String> getProductIds() { return productIds; }
    public void setProductIds(List<String> productIds) { this.productIds = productIds; }
}

class OrderResponseDTO {
    private UUID id;
    private String customerName;
    private LocalDateTime createdAt;

    public OrderResponseDTO() {}

    public OrderResponseDTO(UUID id, String customerName, LocalDateTime createdAt) {
        this.id = id;
        this.customerName = customerName;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}