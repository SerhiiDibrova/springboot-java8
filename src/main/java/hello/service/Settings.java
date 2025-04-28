package hello.service;

import java.util.Map;

public class Settings {
    private Map<String, Object> settings;

    public Settings(Map<String, Object> settings) {
        if (settings == null) {
            throw new IllegalArgumentException("Settings map cannot be null");
        }
        this.settings = settings;
    }

    public Map<String, Object> getSettings() {
        return settings;
    }

    public Object getSetting(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }
        return settings.get(key);
    }

    public void setSetting(String key, Object value) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }
        settings.put(key, value);
    }

    public void removeSetting(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }
        settings.remove(key);
    }
}