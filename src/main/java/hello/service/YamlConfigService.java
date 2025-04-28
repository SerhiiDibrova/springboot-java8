package hello.service;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class YamlConfigService {

    public Map<String, Object> loadFromYaml() throws IOException, FileNotFoundException, YAMLException {
        if (!Files.exists(Paths.get("appsettings.yaml"))) {
            throw new FileNotFoundException("The YAML file 'appsettings.yaml' does not exist.");
        }
        try (InputStream inputStream = Files.newInputStream(Paths.get("appsettings.yaml"))) {
            Yaml yaml = new Yaml();
            return yaml.load(inputStream);
        } catch (YAMLException e) {
            throw new YAMLException("Error parsing the YAML file", e);
        }
    }
}