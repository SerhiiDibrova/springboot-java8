package hello.service;

import hello.model.Settings;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConfigurationService {

    private final YamlConfigService yamlConfigService;

    public ConfigurationService(YamlConfigService yamlConfigService) {
        this.yamlConfigService = yamlConfigService;
    }

    @Cacheable("settings")
    public Settings getSettings() {
        Map<String, Object> yamlConfig = yamlConfigService.loadFromYaml();
        return new Settings(yamlConfig);
    }
}

package hello.service;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class YamlConfigService {

    public Map<String, Object> loadFromYaml() {
        try (InputStream inputStream = new FileInputStream("config.yaml")) {
            Yaml yaml = new Yaml();
            return yaml.load(inputStream);
        } catch (FileNotFoundException e) {
            return new HashMap<>();
        } catch (YAMLException e) {
            return new HashMap<>();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }
}

package hello.model;

import java.util.Map;

public class Settings {
    private final Map<String, Object> settings;

    public Settings(Map<String, Object> settings) {
        this.settings = settings;
    }

    public Map<String, Object> getSettings() {
        return settings;
    }
}