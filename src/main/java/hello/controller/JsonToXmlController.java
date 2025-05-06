package hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.response.ResponseUtil;
import hello.controller.ErrorController;
import hello.declaration.XMLParser;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/json2xml")
public class JsonToXmlController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<?> convertJsonToXml(@RequestParam("file") MultipartFile file,
                                               @RequestHeader(value = "Accept", required = false) String acceptHeader) {
        if (file.isEmpty()) {
            return ErrorController.errorResponse("Uploaded file is empty", 400);
        }

        if (!file.getContentType().equals("application/json")) {
            return ErrorController.errorResponse("Invalid content type, expected application/json", 400);
        }

        if (file.getSize() > 1048576) {
            return ErrorController.errorResponse("File size exceeds limit", 400);
        }

        try (var inputStream = file.getInputStream()) {
            Map<String, Object> jsonData = objectMapper.readValue(inputStream, Map.class);
            String xmlData = XMLParser.parseXmlFromJson(jsonData);

            if ("text/xml".equals(acceptHeader)) {
                return ResponseEntity.ok()
                        .contentType(org.springframework.http.MediaType.TEXT_XML)
                        .body(xmlData);
            } else {
                return ResponseUtil.successResponse(xmlData);
            }
        } catch (IOException e) {
            return ErrorController.errorResponse("Error processing file: " + e.getMessage(), 500);
        }
    }
}