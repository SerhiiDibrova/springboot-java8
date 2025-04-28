package hello.service;

import org.yaml.snakeyaml.Yaml;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Map;

public class ConfigurationLoader {

    public ApplicationConfig loadFromYaml() throws IOException {
        Yaml yaml = new Yaml();
        if (!Files.exists(Paths.get("appsettings.yaml"))) {
            throw new IOException("File not found: appsettings.yaml");
        }
        if (Files.size(Paths.get("appsettings.yaml")) == 0) {
            throw new IOException("File is empty: appsettings.yaml");
        }
        try {
            Map<String, Object> data = yaml.load(Files.newInputStream(Paths.get("appsettings.yaml")));
            if (data == null) {
                throw new IOException("YAML file is improperly formatted: appsettings.yaml");
            }
            return new ApplicationConfig(data);
        } catch (IOException e) {
            throw new IOException("File not found or unable to read", e);
        } catch (Exception e) {
            throw new IOException("Error parsing YAML", e);
        }
    }
}