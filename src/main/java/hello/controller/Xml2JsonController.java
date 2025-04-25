package hello.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonProcessingException;
import hello.controller.SuccessResponse;
import hello.controller.ErrorResponse;
import hello.parser.XMLParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Xml2JsonController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final XMLParser xmlParser = new XMLParser();

    @PostMapping("/convert-xml2json")
    public ResponseEntity<?> convert_xml2json_request(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>(new ErrorResponse("File is empty", HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }

        if (!file.getContentType().equals("text/xml")) {
            return new ResponseEntity<>(new ErrorResponse("Invalid file type. Only text/xml is supported.", HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }

        try {
            String json = xmlParser.parse(file.getInputStream());
            if (json == null || json.isEmpty()) {
                return new ResponseEntity<>(new ErrorResponse("Failed to parse XML file", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            JsonNode jsonNode = objectMapper.readTree(json);
            return new ResponseEntity<>(new SuccessResponse(jsonNode, HttpStatus.OK.value()), HttpStatus.OK);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(new ErrorResponse("Failed to parse JSON: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse("Failed to parse XML file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}