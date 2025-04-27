package hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class CustomConfig {
    @Id
    @NotNull(message = "Order ID cannot be null")
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @NotNull(message = "Config ID cannot be null")
    @Size(max = 50, message = "Config ID must not exceed 50 characters")
    @Column(name = "config_id", nullable = false, length = 50)
    private String configId;

    @NotNull(message = "Module cannot be null")
    @Size(max = 50, message = "Module must not exceed 50 characters")
    @Column(name = "module", nullable = false, length = 50)
    private String module;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomConfig)) return false;
        CustomConfig that = (CustomConfig) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(configId, that.configId) &&
                Objects.equals(module, that.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, configId, module);
    }
}