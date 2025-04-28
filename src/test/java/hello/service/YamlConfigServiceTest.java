package hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class YamlConfigServiceTest {

    private final YamlConfigService yamlConfigService = new YamlConfigService();

    @Test
    void testLoadFromYaml_ValidYaml() throws IOException {
        String yamlContent = "key: value";
        Path tempFile = Files.createTempFile("appsettings", ".yaml");
        Files.write(tempFile, yamlContent.getBytes());

        ConfigData configData = yamlConfigService.loadFromYaml(tempFile.toString());
        Assertions.assertEquals("value", configData.get("key"));

        Files.delete(tempFile);
    }

    @Test
    void testLoadFromYaml_MissingFile() {
        Assertions.assertThrows(IOException.class, () -> {
            yamlConfigService.loadFromYaml("missing.yaml");
        });
    }

    @Test
    void testLoadFromYaml_InvalidYaml() throws IOException {
        Path tempFile = Files.createTempFile("appsettings", ".yaml");
        Files.write(tempFile, "invalid_yaml: [");

        Assertions.assertThrows(YamlParseException.class, () -> {
            yamlConfigService.loadFromYaml(tempFile.toString());
        });

        Files.delete(tempFile);
    }

    @Test
    void testLoadFromYaml_ValidYamlWithMultipleKeys() throws IOException {
        String yamlContent = "key1: value1\nkey2: value2";
        Path tempFile = Files.createTempFile("appsettings", ".yaml");
        Files.write(tempFile, yamlContent.getBytes());

        ConfigData configData = yamlConfigService.loadFromYaml(tempFile.toString());
        Assertions.assertEquals("value1", configData.get("key1"));
        Assertions.assertEquals("value2", configData.get("key2"));

        Files.delete(tempFile);
    }

    @Test
    void testLoadFromYaml_EmptyYaml() throws IOException {
        Path tempFile = Files.createTempFile("appsettings", ".yaml");
        Files.write(tempFile, "".getBytes());

        ConfigData configData = yamlConfigService.loadFromYaml(tempFile.toString());
        Assertions.assertTrue(configData.isEmpty());

        Files.delete(tempFile);
    }
}