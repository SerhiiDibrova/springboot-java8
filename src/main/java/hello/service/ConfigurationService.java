package hello.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import hello.model.ApplicationConfig;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ConfigurationService {
    private static final Logger logger = Logger.getLogger(ConfigurationService.class.getName());
    private static final String CONFIG_FILE_PATH = "config/application.yml";

    @Cacheable("applicationConfig")
    public ApplicationConfig getSettings() {
        if (!Files.exists(Paths.get(CONFIG_FILE_PATH))) {
            logger.log(Level.SEVERE, "Configuration file not found at path: " + CONFIG_FILE_PATH);
            throw new RuntimeException("Configuration file not found at path: " + CONFIG_FILE_PATH);
        }
        try {
            return loadFromYaml();
        } catch (YAMLException e) {
            logger.log(Level.SEVERE, "Error loading configuration from YAML file: " + CONFIG_FILE_PATH, e);
            throw new RuntimeException("Error loading configuration from YAML file: " + CONFIG_FILE_PATH, e);
        }
    }

    private ApplicationConfig loadFromYaml() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = new FileInputStream(CONFIG_FILE_PATH)) {
            return yaml.loadAs(inputStream, ApplicationConfig.class);
        }
    }
}