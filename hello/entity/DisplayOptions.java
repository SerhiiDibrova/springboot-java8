package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DisplayOptions", indexes = {@Index(name = "idx_configId", columnList = "configId")})
public class DisplayOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "configId", nullable = false)
    @NotNull
    private Integer configId;

    @Column(name = "optionName", nullable = false)
    @NotNull
    private String optionName;

    @Column(name = "optionValue")
    private String optionValue;

    @ManyToOne
    @JoinColumn(name = "customConfigId", referencedColumnName = "id")
    private CustomConfig customConfig;

    @ManyToOne
    @JoinColumn(name = "legacyConfigId", referencedColumnName = "id")
    private LegacyConfig legacyConfig;

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
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