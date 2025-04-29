package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Index;
import javax.persistence.Column;

@Entity
@Table(name = "DisplayOptions", indexes = {@Index(name = "idx_configId", columnList = "configId")})
public class DisplayOptions {

    @Id
    @Column(name = "configId", nullable = false)
    private Integer configId;

    @ManyToOne
    @JoinColumn(name = "customConfigId", referencedColumnName = "id", nullable = true)
    private CustomConfig customConfig;

    @ManyToOne
    @JoinColumn(name = "legacyConfigId", referencedColumnName = "id", nullable = true)
    private LegacyConfig legacyConfig;

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public CustomConfig getCustomConfig() {
        return customConfig;
    }

    public void setCustomConfig(CustomConfig customConfig) {
        this.customConfig = customConfig;
    }

    public LegacyConfig getLegacyConfig() {
        return legacyConfig;
    }

    public void setLegacyConfig(LegacyConfig legacyConfig) {
        this.legacyConfig = legacyConfig;
    }
}