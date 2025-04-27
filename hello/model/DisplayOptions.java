package hello.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class DisplayOptions {

    @Id
    @Column(nullable = false, unique = true)
    private String configId;

    @NotNull
    @Size(max = 255)
    private String option1;

    @NotNull
    @Size(max = 255)
    private String option2;

    @NotNull
    @Size(max = 255)
    private String option3;

    @Size(max = 255)
    private String additionalOption1;

    @Size(max = 255)
    private String additionalOption2;

    public DisplayOptions() {
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getAdditionalOption1() {
        return additionalOption1;
    }

    public void setAdditionalOption1(String additionalOption1) {
        this.additionalOption1 = additionalOption1;
    }

    public String getAdditionalOption2() {
        return additionalOption2;
    }

    public void setAdditionalOption2(String additionalOption2) {
        this.additionalOption2 = additionalOption2;
    }
}