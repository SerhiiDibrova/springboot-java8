package hello.dto;

import javax.validation.constraints.NotNull;

public class DisplayOptionsDTO {

    @NotNull
    private Integer configId;

    public DisplayOptionsDTO(@NotNull Integer configId) {
        this.configId = configId;
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }
}