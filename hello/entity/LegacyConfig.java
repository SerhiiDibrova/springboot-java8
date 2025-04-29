package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PersistenceException;

@Entity
@Table(name = "LegacyConfig")
public class LegacyConfig {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private Integer configId;

    private String module;

    @OneToOne
    @JoinColumn(name = "configId", referencedColumnName = "id", insertable = false, updatable = false)
    private CustomConfig customConfig;

    @OneToOne
    @JoinColumn(name = "module", referencedColumnName = "moduleName", insertable = false, updatable = false)
    private DisplayOptions displayOptions;

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

    public CustomConfig getCustomConfig() {
        return customConfig;
    }

    public DisplayOptions getDisplayOptions() {
        return displayOptions;
    }

    public void retrieveData() {
        try {
            // Logic to create and populate temporary table
            // Logic to execute main query
        } catch (PersistenceException e) {
            // Handle potential errors during data retrieval
        }
    }
}