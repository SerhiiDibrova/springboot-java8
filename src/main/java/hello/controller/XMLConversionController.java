package hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Optional;

@RestController
public class XMLConversionController {

    private final XMLParser xmlParser;
    private final ResponseController responseController;
    private final ErrorResponseService errorResponseService;

    public XMLConversionController(XMLParser xmlParser, ResponseController responseController, ErrorResponseService errorResponseService) {
        this.xmlParser = xmlParser;
        this.responseController = responseController;
        this.errorResponseService = errorResponseService;
    }

    /**
     * Converts an XML file to JSON format.
     *
     * @param file the XML file to be converted
     * @return ResponseEntity containing the converted JSON data or an error message
     */
    @PostMapping("/json2xml")
    public ResponseEntity<?> convertXmlToJson(@RequestParam("file") MultipartFile file) {
        if (!file.getContentType().equals("text/xml")) {
            return errorResponseService.errorResponse("Invalid file type. Please upload an XML file.");
        }
        JSONType jsonData = xmlParser.parse(file.getInputStream());
        return responseController.successResponse(jsonData, "Conversion successful");
    }

    /**
     * Converts a JSON file to XML format.
     *
     * @param file        the JSON file to be converted
     * @param acceptHeader the Accept header to determine response format
     * @return ResponseEntity containing the converted XML data or an error message
     */
    @PostMapping("/json2xml")
    public ResponseEntity<?> convertJsonToXml(@RequestParam("file") MultipartFile file,
                                               @RequestHeader(value = "Accept", required = false) String acceptHeader) {
        if (!file.getContentType().equals("application/json")) {
            return errorResponseService.errorResponse("Invalid file type. Please upload a JSON file.");
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonData = objectMapper.readValue(file.getInputStream(), Map.class);
            String xmlData = xmlParser.convertToXml(jsonData);
            if (Optional.ofNullable(acceptHeader).orElse("").equals("text/xml")) {
                return ResponseEntity.ok().contentType(org.springframework.http.MediaType.TEXT_XML).body(xmlData);
            } else {
                return responseController.successResponse(xmlData, "Conversion successful");
            }
        } catch (Exception e) {
            return errorResponseService.errorResponse("Error processing the file: " + e.getMessage());
        }
    }
}