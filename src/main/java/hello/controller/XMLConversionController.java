package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import hello.service.XMLConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/xml2json")
public class XMLConversionController {

    private final XMLConversionService xmlConversionService;
    private static final Logger logger = LoggerFactory.getLogger(XMLConversionController.class);
    private static final long MAX_FILE_SIZE = 10485760; // 10 MB

    @Autowired
    public XMLConversionController(XMLConversionService xmlConversionService) {
        this.xmlConversionService = xmlConversionService;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<String> convert_xml2json_request(MultipartFile file) {
        if (file.isEmpty() || !file.getContentType().equals("application/xml")) {
            return ResponseEntity.badRequest().body("Invalid file type. Please upload an XML file.");
        }
        if (file.getSize() > MAX_FILE_SIZE) {
            return ResponseEntity.badRequest().body("File size exceeds the maximum limit of 10 MB.");
        }
        try {
            String jsonResponse = xmlConversionService.convertXMLToJSON(file);
            return ResponseEntity.ok(jsonResponse);
        } catch (Exception e) {
            logger.error("Error converting XML to JSON", e);
            return ResponseEntity.status(500).body("Error processing the file. Please try again.");
        }
    }
}