package hello.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Map;
import hello.service.YamlConfigService;

@Service
public class SettingsService {

    private final YamlConfigService yamlConfigService;

    public SettingsService(YamlConfigService yamlConfigService) {
        this.yamlConfigService = yamlConfigService;
    }

    @Cacheable("settingsCache")
    public Settings getSettings() {
        Map<String, Object> settingsMap = yamlConfigService.loadFromYaml();
        return new Settings(settingsMap);
    }
}

public class Settings {
    private final Map<String, Object> settings;

    public Settings(Map<String, Object> settings) {
        this.settings = settings;
    }

    public Map<String, Object> getSettings() {
        return settings;
    }
}