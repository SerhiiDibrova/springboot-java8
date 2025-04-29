package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Index;

@Entity
@Table(name = "CustomConfig", indexes = {@Index(name = "idx_configId", columnList = "configId"), @Index(name = "idx_module", columnList = "module")})
public class CustomConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_config_seq")
    @SequenceGenerator(name = "custom_config_seq", sequenceName = "custom_config_sequence", allocationSize = 1)
    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "configId", nullable = false)
    private String configId;

    @Column(name = "module", nullable = false)
    private String module;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
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