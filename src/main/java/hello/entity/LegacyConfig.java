package hello.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LegacyConfig", 
       indexes = {
           @Index(name = "idx_order_id", columnList = "order_id"),
           @Index(name = "idx_config_id", columnList = "config_id")
       },
       uniqueConstraints = @UniqueConstraint(columnNames = {"order_id", "config_id"}))
public class LegacyConfig {

    @Id
    @NotNull
    @Column(name = "order_id")
    private Integer orderId;

    @NotNull
    @Column(name = "config_id")
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