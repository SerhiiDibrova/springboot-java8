package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import hello.controller.ResponseUtil;
import hello.controller.ErrorResponseUtil;
import hello.model.XMLParser;
import hello.service.XMLConversionService;

@RestController
@RequestMapping("/api")
public class XMLConversionController {

    /**
     * Converts an XML file to JSON format.
     *
     * @param file the XML file to be converted
     * @return ResponseEntity containing the converted JSON data or an error message
     */
    @PostMapping("/xml2json")
    public ResponseEntity<?> convertXmlToJsonRequest(@RequestParam("file") MultipartFile file) {
        if (!file.getContentType().equals("text/xml")) {
            return ErrorResponseUtil.createErrorResponse("Invalid content type. Please upload an XML file.", HttpStatus.BAD_REQUEST);
        }
        try {
            String jsonData = XMLParser._parse_etree_to_json_type(file.getInputStream());
            return ResponseUtil.createSuccessResponse(jsonData, HttpStatus.OK);
        } catch (Exception e) {
            return ErrorResponseUtil.createErrorResponse("Error processing the XML file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/json2xml")
    public ResponseEntity<?> convertJsonToXmlRequest(@RequestParam("file") MultipartFile file, @RequestHeader(value = "Optional-Header", required = false) String optionalHeader) {
        if (!file.getContentType().equals("application/json")) {
            return ErrorResponseUtil.createErrorResponse("Invalid content type. Please upload a JSON file.", HttpStatus.BAD_REQUEST);
        }
        try {
            String xmlData = XMLConversionService.convertJsonToXml(file.getInputStream());
            return ResponseUtil.createSuccessResponse(xmlData, HttpStatus.OK);
        } catch (Exception e) {
            return ErrorResponseUtil.createErrorResponse("Error processing the JSON file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}