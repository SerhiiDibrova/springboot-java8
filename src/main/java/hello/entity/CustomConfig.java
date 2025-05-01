package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CustomConfig", indexes = {
    @Index(name = "idx_order_id", columnList = "order_id"),
    @Index(name = "idx_config_id", columnList = "config_id")
})
@IdClass(CustomConfigId.class)
public class CustomConfig {

    @Id
    @NotNull
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Id
    @NotNull
    @Column(name = "config_id", nullable = false)
    private Integer configId;

    @NotNull
    @Column(name = "module", nullable = false)
    private String module;

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

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}

import java.io.Serializable;
import java.util.Objects;

class CustomConfigId implements Serializable {
    private Integer orderId;
    private Integer configId;

    public CustomConfigId() {}

    public CustomConfigId(Integer orderId, Integer configId) {
        this.orderId = orderId;
        this.configId = configId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomConfigId)) return false;
        CustomConfigId that = (CustomConfigId) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(configId, that.configId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, configId);
    }
}