package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

@Entity
@Table(name = "#TempItems", indexes = {
    @Index(name = "idx_orderId", columnList = "orderId"),
    @Index(name = "idx_configId", columnList = "configId")
})
public class TempItem {

    @Id
    @NotNull
    private Integer orderId;

    @NotNull
    private Integer configId;

    @Min(1)
    @Max(100)
    private Integer quantity;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}