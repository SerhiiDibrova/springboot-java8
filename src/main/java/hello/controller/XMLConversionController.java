package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import hello.util.ResponseUtil;
import hello.util.XMLParser;
import hello.util.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/xml2json")
public class XMLConversionController {

    private static final Logger logger = LoggerFactory.getLogger(XMLConversionController.class);

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> convert_xml2json_request(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("No file uploaded. Please upload an XML file."));
        }
        if (!file.getContentType().equals("text/xml")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Invalid file type. Please upload an XML file."));
        }
        try {
            String jsonData = XMLParser.parse_xml_from_file(file.getInputStream());
            return ResponseUtil.successResponse(jsonData);
        } catch (Exception e) {
            logger.error("Error processing the XML file: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error processing the XML file: " + e.getMessage()));
        }
    }
}