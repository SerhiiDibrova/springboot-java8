package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Inventory")
@IdClass(InventoryId.class)
public class Inventory {

    @Id
    @NotNull
    @Column(name = "order_id")
    private Integer orderId;

    @Id
    @NotNull
    @Column(name = "warehouse_id")
    private Integer warehouseId;

    @NotNull
    @Min(0)
    @Column(name = "stock_level", nullable = false)
    private Integer stockLevel;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Warehouses warehouse;

    public Inventory() {
        this.stockLevel = 0;
    }

    public Inventory(Integer orderId, Integer warehouseId, Integer stockLevel) {
        this.orderId = orderId;
        this.warehouseId = warehouseId;
        this.stockLevel = stockLevel;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }
}