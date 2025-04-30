package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "DisplayOptions")
public class DisplayOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "configId")
    private Integer configId;

    @NotNull
    @Column(name = "optionName")
    private String optionName;

    @Column(name = "optionValue")
    private String optionValue;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "displayOptions", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RelatedEntity> relatedEntities;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RelatedEntity> getRelatedEntities() {
        return relatedEntities;
    }

    public void setRelatedEntities(List<RelatedEntity> relatedEntities) {
        this.relatedEntities = relatedEntities;
    }
}