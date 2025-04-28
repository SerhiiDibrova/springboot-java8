package hello.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import hello.config.YamlConfigService;
import hello.model.ConfigData;
import hello.model.Settings;

@Service
public class SettingsService {

    private final YamlConfigService yamlConfigService;

    public SettingsService(YamlConfigService yamlConfigService) {
        this.yamlConfigService = yamlConfigService;
    }

    @Cacheable("settings")
    public Settings getSettings() {
        ConfigData configData = yamlConfigService.loadFromYaml();
        return new Settings(configData);
    }
}