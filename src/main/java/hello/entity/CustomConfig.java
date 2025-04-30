package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "CustomConfig", uniqueConstraints = @UniqueConstraint(columnNames = {"orderId", "configId"}))
public class CustomConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "config_id", nullable = false)
    private Integer configId;

    @NotNull
    @Size(max = 50)
    @Column(name = "module", nullable = false, length = 50)
    private String module;

    @OneToMany(mappedBy = "customConfig")
    private Set<DisplayOptions> displayOptions;

    @OneToMany(mappedBy = "customConfig")
    private Set<TempItem> tempItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<DisplayOptions> getDisplayOptions() {
        return displayOptions;
    }

    public void setDisplayOptions(Set<DisplayOptions> displayOptions) {
        this.displayOptions = displayOptions;
    }

    public Set<TempItem> getTempItems() {
        return tempItems;
    }

    public void setTempItems(Set<TempItem> tempItems) {
        this.tempItems = tempItems;
    }
}