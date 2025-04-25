package hello.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class WarehouseDataResponse {
    private Long id;
    private String productName;
    private Integer quantity;
    private LocalDateTime lastUpdated;

    public WarehouseDataResponse(Long id, String productName, Integer quantity, LocalDateTime lastUpdated) {
        if (id == null || productName == null || quantity == null || lastUpdated == null) {
            throw new IllegalArgumentException("All fields must be provided");
        }
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.lastUpdated = lastUpdated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "WarehouseDataResponse{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WarehouseDataResponse)) return false;
        WarehouseDataResponse that = (WarehouseDataResponse) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, quantity, lastUpdated);
    }
}