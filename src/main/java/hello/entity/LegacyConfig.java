package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LegacyConfig", uniqueConstraints = @UniqueConstraint(columnNames = {"orderId", "config_id"}))
public class LegacyConfig {

    @Column(name = "order_id")
    private Integer orderId;

    @NotNull
    @Column(name = "config_id")
    private Integer configId;

    @NotNull
    @Column(length = 50)
    private String module;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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