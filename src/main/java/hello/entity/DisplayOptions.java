package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "DisplayOptions")
public class DisplayOptions {

    @Id
    @GeneratedValue
    @NotNull
    @Column(nullable = false)
    private Long config_id;

    @NotNull
    @Column(nullable = false)
    private String option_name;

    @Column
    private String option_value;

    @Column
    private String description;

    @OneToMany(mappedBy = "displayOption")
    private List<CustomConfig> customConfigs;

    @OneToMany(mappedBy = "displayOption")
    private List<LegacyConfig> legacyConfigs;

    public Long getConfigId() {
        return config_id;
    }

    public void setConfigId(Long config_id) {
        this.config_id = config_id;
    }

    public String getOptionName() {
        return option_name;
    }

    public void setOptionName(String option_name) {
        this.option_name = option_name;
    }

    public String getOptionValue() {
        return option_value;
    }

    public void setOptionValue(String option_value) {
        this.option_value = option_value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CustomConfig> getCustomConfigs() {
        return customConfigs;
    }

    public void setCustomConfigs(List<CustomConfig> customConfigs) {
        this.customConfigs = customConfigs;
    }

    public List<LegacyConfig> getLegacyConfigs() {
        return legacyConfigs;
    }

    public void setLegacyConfigs(List<LegacyConfig> legacyConfigs) {
        this.legacyConfigs = legacyConfigs;
    }
}