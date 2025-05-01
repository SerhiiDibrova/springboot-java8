package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Entity
@Table(name = "Legacy_Logistics", uniqueConstraints = @UniqueConstraint(columnNames = {"warehouseId", "orderId"}))
public class LegacyLogistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logisticsId;

    @NotNull
    @Column(nullable = false)
    private Long warehouseId;

    @NotNull
    @Column(nullable = false)
    private Long orderId;

    @Positive
    @NotNull
    @Column(nullable = false)
    private Double logisticsEfficiency;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdDate;

    public LegacyLogistics() {
        this.createdDate = LocalDateTime.now();
        this.logisticsEfficiency = 0.0;
    }

    public Long getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(Double logisticsEfficiency) {
        this.logisticsEfficiency = logisticsEfficiency;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}