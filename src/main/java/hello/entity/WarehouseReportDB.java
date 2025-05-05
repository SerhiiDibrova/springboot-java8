package hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class WarehouseReportDB {

    @Id
    @NotNull
    @Column(name = "OrderId")
    private Long orderId;

    @NotNull
    @Column(name = "WarehouseId")
    private Long warehouseId;

    @NotNull
    @Column(name = "ItemCount")
    private Integer itemCount = 0;

    @NotNull
    @Column(name = "TotalValue")
    private BigDecimal totalValue = BigDecimal.ZERO;

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