package hello.model;

import hello.entity.OrderDB;
import java.time.LocalDateTime;

public class OrderDTO {
    private long id;
    private String customerName;
    private LocalDateTime createdAt;

    public OrderDTO() {}

    public OrderDTO(long id, String customerName, LocalDateTime createdAt) {
        this.id = id;
        this.customerName = customerName;
        this.createdAt = createdAt;
    }

    public OrderDTO(OrderDB orderDB) {
        this.id = orderDB.getId();
        this.customerName = orderDB.getCustomerName();
        this.createdAt = orderDB.getCreatedAt();
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}