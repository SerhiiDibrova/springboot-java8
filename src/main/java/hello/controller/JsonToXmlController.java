package hello.controller;

import hello.service.JsonToXmlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class JsonToXmlController {

    private final JsonToXmlService jsonToXmlService;
    private static final Logger logger = LoggerFactory.getLogger(JsonToXmlController.class);

    @Autowired
    public JsonToXmlController(JsonToXmlService jsonToXmlService) {
        this.jsonToXmlService = jsonToXmlService;
    }

    @PostMapping("/json2xml")
    public ResponseEntity<String> convertJsonToXml(@RequestParam("file") MultipartFile file,
                                                    @RequestHeader(value = HttpHeaders.ACCEPT, required = false) String acceptHeader) {
        if (file.isEmpty() || !file.getContentType().equals("application/json")) {
            return new ResponseEntity<>("Invalid file type. Please upload a JSON file.", HttpStatus.BAD_REQUEST);
        }

        try {
            logger.info("Starting JSON to XML conversion for file: {}", file.getOriginalFilename());
            String xmlResponse = jsonToXmlService.convertJsonToXml(file);
            logger.info("Successfully converted JSON to XML for file: {}", file.getOriginalFilename());
            return new ResponseEntity<>(xmlResponse, HttpStatus.OK);
        } catch (IOException e) {
            logger.error("Error during JSON to XML conversion: {}", e.getMessage());
            return new ResponseEntity<>("Error processing the file.", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            logger.error("Unexpected error: {}", e.getMessage());
            return new ResponseEntity<>("Unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}