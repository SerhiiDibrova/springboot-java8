package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "#WarehouseReport")
public class WarehouseReport {

    @Id
    @Column(name = "OrderId", nullable = false)
    @NotNull
    private Long orderId;

    @Column(name = "WarehouseId", nullable = false)
    @NotNull
    private Long warehouseId;

    @Column(name = "ItemCount", nullable = false)
    @NotNull
    @Min(0)
    private Integer itemCount;

    @Column(name = "TotalValue", nullable = false)
    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal totalValue;

    @ManyToOne
    @JoinColumn(name = "WarehouseId", referencedColumnName = "Id", insertable = false, updatable = false)
    private Warehouse warehouse;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }
}