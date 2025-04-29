package hello.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "display_options")
public class DisplayOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "config_id", nullable = false)
    @Index(name = "idx_config_id")
    private Integer configId;

    @Column(name = "other_display_option_field_1")
    private String otherDisplayOptionField1;

    @Column(name = "other_display_option_field_2")
    private String otherDisplayOptionField2;

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public String getOtherDisplayOptionField1() {
        return otherDisplayOptionField1;
    }

    public void setOtherDisplayOptionField1(String otherDisplayOptionField1) {
        this.otherDisplayOptionField1 = otherDisplayOptionField1;
    }

    public String getOtherDisplayOptionField2() {
        return otherDisplayOptionField2;
    }

    public void setOtherDisplayOptionField2(String otherDisplayOptionField2) {
        this.otherDisplayOptionField2 = otherDisplayOptionField2;
    }
}