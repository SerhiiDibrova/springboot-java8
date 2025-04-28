package hello.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Logistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warehouseId;
    private Double logisticsEfficiency;

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Double getLogisticsEfficiency() {
        return logisticsEfficiency;
    }

    public void setLogisticsEfficiency(Double logisticsEfficiency) {
        this.logisticsEfficiency = logisticsEfficiency;
    }
}