package hello.service;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

@Service
public class YamlConfigService {

    public Map<String, Object> loadFromYaml() throws IOException {
        Map<String, Object> configData = new HashMap<>();
        try (InputStream inputStream = Files.newInputStream(Paths.get("appsettings.yaml"))) {
            Yaml yaml = new Yaml();
            configData = yaml.load(inputStream);
        } catch (NoSuchFileException e) {
            throw new IOException("YAML file not found: appsettings.yaml", e);
        } catch (IOException e) {
            throw new IOException("Error reading YAML file: appsettings.yaml", e);
        } catch (Exception e) {
            throw new IOException("Invalid YAML format or parsing error", e);
        }
        return configData;
    }
}