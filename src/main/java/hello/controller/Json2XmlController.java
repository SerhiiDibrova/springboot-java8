package hello.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import hello.controller.ErrorResponse;
import hello.controller.SuccessResponse;
import hello.util.XMLParser;

@RestController
public class Json2XmlController {

    @PostMapping("/convert")
    public ResponseEntity<Object> convertJson2XmlRequest(@RequestParam("file") MultipartFile file, HttpHeaders headers) {
        String acceptHeader = headers.getFirst("Accept");
        String contentType = file.getContentType();

        if (file.isEmpty() || contentType == null || !contentType.equals("application/json")) {
            ErrorResponse errorResponse = new ErrorResponse("Invalid file type. Only application/json is supported.");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(file.getInputStream());
            Document document = XMLParser.parseXmlFromJson(jsonNode);
            Element root = document.getDocumentElement();
            String xmlString = XMLParser.etreeToString(root);

            if (acceptHeader != null && acceptHeader.equals("text/xml")) {
                return ResponseEntity.ok().contentType(MediaType.TEXT_XML).body(xmlString);
            } else {
                SuccessResponse successResponse = new SuccessResponse(xmlString);
                return ResponseEntity.ok(successResponse);
            }
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("Error converting JSON to XML: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }
}