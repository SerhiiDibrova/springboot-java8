package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import hello.service.XMLParserService;
import hello.exception.XMLParseError;
import hello.exception.ErrorResponseException;
import hello.model.XMLParser;
import org.springframework.http.ResponseEntity;
import org.json.JSONObject;
import org.json.XML;

@Service
public class XMLConversionService {

    private final XMLParserService xmlParserService;

    public XMLConversionService(XMLParserService xmlParserService) {
        this.xmlParserService = xmlParserService;
    }

    public ResponseEntity<?> convertJsonToXml(MultipartFile file, String acceptHeader) {
        if (!file.getContentType().equals("application/json")) {
            return ResponseEntity.badRequest().body("Invalid file type. Please upload a JSON file.");
        }

        try {
            String jsonContent = new String(file.getBytes());
            JSONObject jsonObject = new JSONObject(jsonContent);
            String xml = XML.toString(jsonObject);
            if ("application/xml".equals(acceptHeader)) {
                return ResponseEntity.ok(xml);
            } else {
                return ResponseEntity.ok(new JSONObject().put("xml", xml).toString());
            }
        } catch (org.json.JSONException e) {
            throw new XMLParseError("Error parsing JSON to XML: Invalid JSON format", e);
        } catch (Exception e) {
            throw new XMLParseError("Error parsing JSON to XML", e);
        }
    }
}