package hello.service;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.YAMLException;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Service
public class YamlConfigService {

    /**
     * Loads configuration settings from a YAML file.
     *
     * @return a Map containing the configuration settings
     * @throws FileNotFoundException if the YAML file is not found
     * @throws YAMLParseException if there is an error parsing the YAML file
     * @throws Exception for any other errors that may occur
     */
    public Map<String, Object> loadFromYaml() throws FileNotFoundException, YAMLParseException {
        try (InputStream inputStream = Files.newInputStream(Paths.get("appsettings.yaml"))) {
            Yaml yaml = new Yaml(new Constructor(Map.class));
            return yaml.load(inputStream);
        } catch (IOException e) {
            throw new FileNotFoundException("YAML file not found: " + e.getMessage());
        } catch (YAMLException e) {
            throw new YAMLParseException("Error parsing YAML file: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("An error occurred while loading the YAML file: " + e.getMessage());
        }
    }
}

class FileNotFoundException extends Exception {
    public FileNotFoundException(String message) {
        super(message);
    }
}

class YAMLParseException extends Exception {
    public YAMLParseException(String message) {
        super(message);
    }
}