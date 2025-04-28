package hello.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class XMLConversionService {

    private final XMLParserService xmlParserService;
    private static final Logger logger = LoggerFactory.getLogger(XMLConversionService.class);

    public XMLConversionService(XMLParserService xmlParserService) {
        this.xmlParserService = xmlParserService;
    }

    public ResponseEntity<?> convertXmlToJson(MultipartFile file) {
        if (file == null || !file.getContentType().equals("text/xml")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file type. Please upload an XML file.");
        }
        
        try {
            String jsonResult = xmlParserService.parseXmlToJson(file);
            return ResponseEntity.ok().body(new JsonResponse(jsonResult));
        } catch (XmlParsingException e) {
            logger.error("XML parsing error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing the XML file: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred.");
        }
    }
}

class JsonResponse {
    private String json;

    public JsonResponse(String json) {
        this.json = json;
    }

    public String getJson() {
        return json;
    }
}