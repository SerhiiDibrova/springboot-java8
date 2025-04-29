package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CustomConfig")
public class CustomConfig {

    @Id
    @NotNull
    private Integer orderId;

    @NotNull
    @Column(name = "configId", nullable = false)
    private Integer configId;

    @NotNull
    @Column(name = "module", nullable = false, length = 255)
    private String module;

    public CustomConfig() {
    }

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