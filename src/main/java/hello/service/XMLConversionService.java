package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import hello.model.XMLParser;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

@Service
public class XMLConversionService {

    public String convertFileJsonToXml(MultipartFile file) throws IOException {
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("application/json")) {
            throw new IllegalArgumentException("File type must be JSON");
        }
        
        String jsonContent = new String(file.getBytes(), StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(jsonContent);
        XMLParser xmlParser = new XMLParser();
        return xmlParser.convert(jsonObject);
    }
}