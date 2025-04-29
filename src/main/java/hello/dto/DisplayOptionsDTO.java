package hello.dto;

public class DisplayOptionsDTO {
    private Long configId;
    private String displayName;
    private Boolean isEnabled;
    private String theme;
    private Integer refreshRate;

    public DisplayOptionsDTO() {
    }

    public DisplayOptionsDTO(Long configId, String displayName, Boolean isEnabled, String theme, Integer refreshRate) {
        this.configId = configId;
        this.displayName = displayName;
        this.isEnabled = isEnabled;
        this.theme = theme;
        this.refreshRate = refreshRate;
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

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(Integer refreshRate) {
        this.refreshRate = refreshRate;
    }
}