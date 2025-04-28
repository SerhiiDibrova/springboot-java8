package hello.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class YamlConfigService {

    @Value("${yaml.file.path:appsettings.yaml}")
    private String yamlFilePath;

    public Map<String, Object> loadFromYaml() {
        try (InputStream inputStream = Files.newInputStream(Paths.get(yamlFilePath))) {
            Yaml yaml = new Yaml();
            return yaml.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("YAML file not found or could not be read: " + yamlFilePath, e);
        } catch (Exception e) {
            throw new RuntimeException("Error loading YAML configuration", e);
        }
    }
}