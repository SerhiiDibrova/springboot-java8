package hello.service;

import org.springframework.cache.annotation.Cacheable;
import hello.model.Settings;
import java.util.Map;
import java.util.logging.Logger;

public class SettingsService {
    private static final Logger logger = Logger.getLogger(SettingsService.class.getName());

    @Cacheable("settings")
    public static Settings getSettings() {
        try {
            Map<String, Object> configData = YamlConfigService.loadFromYaml();
            return new Settings(configData);
        } catch (IllegalArgumentException | IOException e) {
            logger.severe("Failed to load settings: " + e.getMessage());
            throw new RuntimeException("Error loading settings", e);
        }
    }
}