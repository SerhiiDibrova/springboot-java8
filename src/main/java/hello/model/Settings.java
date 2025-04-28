package hello.model;

import java.util.Map;

public class Settings {
    private String setting1;
    private int setting2;
    private boolean setting3;

    public Settings(Map<String, Object> config) {
        if (config.containsKey("setting1") && config.get("setting1") instanceof String) {
            this.setting1 = (String) config.get("setting1");
        } else {
            throw new IllegalArgumentException("Missing or invalid type for setting1");
        }

        if (config.containsKey("setting2") && config.get("setting2") instanceof Integer) {
            this.setting2 = (Integer) config.get("setting2");
        } else {
            throw new IllegalArgumentException("Missing or invalid type for setting2");
        }

        if (config.containsKey("setting3") && config.get("setting3") instanceof Boolean) {
            this.setting3 = (Boolean) config.get("setting3");
        } else {
            throw new IllegalArgumentException("Missing or invalid type for setting3");
        }
    }

    public String getSetting1() {
        return setting1;
    }

    public int getSetting2() {
        return setting2;
    }

    public boolean isSetting3() {
        return setting3;
    }
}