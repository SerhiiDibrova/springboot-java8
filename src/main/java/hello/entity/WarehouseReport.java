package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "#WarehouseReport")
public class WarehouseReport {

    @Id
    @Column(name = "OrderId", nullable = false)
    @NotNull
    private Long orderId;

    @Column(name = "ItemName", nullable = false)
    @NotNull
    private String itemName;

    @Column(name = "Quantity", nullable = false)
    @NotNull
    private Integer quantity;

    @Column(name = "WarehouseId", nullable = false)
    @NotNull
    private Long warehouseId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }
}