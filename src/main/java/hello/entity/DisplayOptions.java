package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "DisplayOptions")
public class DisplayOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "config_id")
    private Long configId;

    @NotNull
    @Size(max = 100)
    private String displayName;

    @NotNull
    private String displayType;

    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "custom_config_id")
    private CustomConfig customConfig;

    @ManyToOne
    @JoinColumn(name = "legacy_config_id")
    private LegacyConfig legacyConfig;

    public DisplayOptions() {
    }

    public DisplayOptions(Long configId, String displayName, String displayType, Boolean isActive, CustomConfig customConfig, LegacyConfig legacyConfig) {
        this.configId = configId;
        this.displayName = displayName;
        this.displayType = displayType;
        this.isActive = isActive;
        this.customConfig = customConfig;
        this.legacyConfig = legacyConfig;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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