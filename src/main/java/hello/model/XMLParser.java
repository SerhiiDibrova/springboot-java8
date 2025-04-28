package hello.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class XMLParser {
    public static String parseXmlFromJson(String jsonData) throws IOException {
        if (jsonData == null || jsonData.isEmpty()) {
            throw new IllegalArgumentException("Input JSON data cannot be null or empty");
        }
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = jsonMapper.readTree(jsonData);
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid JSON input", e);
        }
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(jsonNode);
    }
}