package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import hello.service.ResponseService;
import hello.service.ErrorResponseService;
import hello.service.XMLConversionService;
import hello.service.XMLParserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.Optional;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

@RestController
@RequestMapping("/api")
public class XMLConversionController {

    @Autowired
    private ResponseService responseService;

    @Autowired
    private ErrorResponseService errorResponseService;

    @Autowired
    private XMLConversionService xmlConversionService;

    @Autowired
    private XMLParserService xmlParserService;

    @PostMapping("/xml2json")
    public ResponseEntity<?> convertXmlToJson(@RequestParam("file") MultipartFile file) {
        if (!file.getContentType().equals("text/xml")) {
            return errorResponseService.errorResponse("Invalid file type. Please upload an XML file.", HttpStatus.BAD_REQUEST);
        }
        try {
            String jsonResult = xmlConversionService.convertXmlToJson(file);
            return responseService.successResponse(jsonResult);
        } catch (ParserConfigurationException | SAXException e) {
            return errorResponseService.errorResponse("XML parsing error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return errorResponseService.errorResponse("Conversion failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/json2xml")
    public ResponseEntity<?> convertJsonToXml(@RequestParam("file") MultipartFile file, @RequestHeader(value = "Accept", required = false) String acceptHeader) {
        if (!file.getContentType().equals("application/json")) {
            return errorResponseService.errorResponse("Invalid file type. Please upload a JSON file.", HttpStatus.BAD_REQUEST);
        }
        if (Optional.ofNullable(acceptHeader).orElse("").isEmpty()) {
            return errorResponseService.errorResponse("Accept header is required.", HttpStatus.BAD_REQUEST);
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonMap = objectMapper.readValue(file.getInputStream(), Map.class);
            String xmlResult = xmlParserService.convertJsonToXml(jsonMap);
            if (acceptHeader.equals("text/xml")) {
                return ResponseEntity.ok().contentType(org.springframework.http.MediaType.TEXT_XML).body(xmlResult);
            } else {
                return responseService.successResponse(xmlResult);
            }
        } catch (IOException e) {
            return errorResponseService.errorResponse("Conversion failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}