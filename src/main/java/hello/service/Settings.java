package hello.service;

import java.util.Map;

public class Settings {
    private String settingOne;
    private int settingTwo;
    private boolean settingThree;

    public Settings(Map<String, Object> config) {
        this.settingOne = (String) config.getOrDefault("settingOne", "defaultOne");
        this.settingTwo = (Integer) config.getOrDefault("settingTwo", 0);
        this.settingThree = (Boolean) config.getOrDefault("settingThree", false);
        
        if (config.get("settingTwo") != null && !(config.get("settingTwo") instanceof Integer)) {
            throw new ClassCastException("settingTwo must be an Integer");
        }
        if (config.get("settingThree") != null && !(config.get("settingThree") instanceof Boolean)) {
            throw new ClassCastException("settingThree must be a Boolean");
        }
        if (config.get("settingOne") != null && !(config.get("settingOne") instanceof String)) {
            throw new ClassCastException("settingOne must be a String");
        }
    }

    public String getSettingOne() {
        return settingOne;
    }

    public int getSettingTwo() {
        return settingTwo;
    }

    public boolean isSettingThree() {
        return settingThree;
    }
}