package hello.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class LegacyConfig {
    @Id
    @NotNull
    private Integer orderId;

    @NotNull
    @Size(min = 1, max = 255)
    private String configId;

    @NotNull
    @Size(min = 1, max = 255)
    private String module;

    public LegacyConfig() {
    }

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
}