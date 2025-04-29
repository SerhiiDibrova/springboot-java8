package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "CustomConfig")
@IdClass(CustomConfigId.class)
public class CustomConfig {

    @Id
    @NotNull
    @Column(name = "orderId")
    private Integer orderId;

    @Id
    @NotNull
    @Column(name = "configId")
    private Integer configId;

    @NotNull
    @Column(name = "module")
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

public class CustomConfigId implements Serializable {
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
        return orderId.equals(that.orderId) && configId.equals(that.configId);
    }

    @Override
    public int hashCode() {
        return 31 * orderId.hashCode() + configId.hashCode();
    }
}