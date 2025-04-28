package hello.service;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class YamlConfigService {

    public Map<String, Object> loadFromYaml() {
        String filePath = "appsettings.yaml";
        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
            if (inputStream == null) {
                throw new FileNotFoundException("YAML file not found: " + filePath);
            }
            Yaml yaml = new Yaml();
            return yaml.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (YAMLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}