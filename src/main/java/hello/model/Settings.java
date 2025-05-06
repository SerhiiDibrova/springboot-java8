package hello.model;

import hello.service.ConfigurationService;
import hello.service.YamlConfigService;
import java.util.HashMap;
import java.util.Map;

public class Settings {
    private Map<String, Object> settings;

    public Settings(Map<String, Object> settings) {
        this.settings = new HashMap<>(settings);
    }

    public static Settings loadFromYaml(String filePath) {
        YamlConfigService yamlConfigService = new YamlConfigService();
        Map<String, Object> settings = yamlConfigService.load(filePath);
        return new Settings(settings);
    }

    public Object getSetting(String key) {
        return settings.get(key);
    }

    public void setSetting(String key, Object value) {
        settings.put(key, value);
    }

    public Map<String, Object> getAllSettings() {
        return new HashMap<>(settings);
    }
}