package hello.dto;

public class DisplayOptionsDTO {
    private Integer configId;

    public DisplayOptionsDTO() {
    }

    public DisplayOptionsDTO(Integer configId) {
        this.configId = configId;
    }

    public Integer getConfigId() {
        return configId;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }
}