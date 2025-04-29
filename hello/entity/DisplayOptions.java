package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class DisplayOptions {

    @Id
    @NotNull
    private Integer configId;

    @NotNull
    private String optionName;

    @ManyToOne
    private ConfigurationEntity configuration;

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

    public ConfigurationEntity getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ConfigurationEntity configuration) {
        this.configuration = configuration;
    }
}

package hello.repository;

import hello.entity.DisplayOptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisplayOptionsRepository extends JpaRepository<DisplayOptions, Integer> {
}