package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@IdClass(LegacyConfigId.class)
@Entity
@Table(name = "LegacyConfig")
public class LegacyConfig {

    @Id
    @NotNull
    private Integer orderId;

    @Id
    @NotNull
    private Integer configId;

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

class LegacyConfigId implements Serializable {
    private Integer orderId;
    private Integer configId;

    public LegacyConfigId() {}

    public LegacyConfigId(Integer orderId, Integer configId) {
        this.orderId = orderId;
        this.configId = configId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LegacyConfigId)) return false;
        LegacyConfigId that = (LegacyConfigId) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(configId, that.configId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, configId);
    }
}