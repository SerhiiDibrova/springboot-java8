package hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import hello.service.XMLConversionService;
import hello.service.ResponseService;
import hello.service.ErrorResponseService;
import hello.exception.ErrorResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class XMLConversionController {

    private final XMLConversionService xmlConversionService;
    private final ResponseService responseService;
    private final ErrorResponseService errorResponseService;
    private static final Logger logger = LoggerFactory.getLogger(XMLConversionController.class);

    public XMLConversionController(XMLConversionService xmlConversionService, ResponseService responseService, ErrorResponseService errorResponseService) {
        this.xmlConversionService = xmlConversionService;
        this.responseService = responseService;
        this.errorResponseService = errorResponseService;
    }

    @PostMapping("/xml2json")
    public ResponseEntity<?> convertXmlToJson(@RequestParam("file") MultipartFile file) {
        try {
            validateFile(file, "application/xml");
            String jsonResponse = xmlConversionService.convertXmlToJson(file);
            return responseService.createSuccessResponse(jsonResponse);
        } catch (ErrorResponseException e) {
            logger.error("Error converting XML to JSON: {}", e.getMessage());
            return errorResponseService.createErrorResponse(e);
        } catch (Exception e) {
            logger.error("Unexpected error: {}", e.getMessage());
            return errorResponseService.createErrorResponse(new ErrorResponseException("An unexpected error occurred."));
        }
    }

    @PostMapping("/json2xml")
    public ResponseEntity<?> convertJsonToXml(@RequestParam("file") MultipartFile file, 
                                               @RequestHeader(value = "Accept", required = false) String acceptHeader) {
        try {
            validateFile(file, "application/json");
            String xmlResponse = xmlConversionService.convertJsonToXml(file);
            return responseService.createSuccessResponse(xmlResponse);
        } catch (ErrorResponseException e) {
            logger.error("Error converting JSON to XML: {}", e.getMessage());
            return errorResponseService.createErrorResponse(e);
        } catch (Exception e) {
            logger.error("Unexpected error: {}", e.getMessage());
            return errorResponseService.createErrorResponse(new ErrorResponseException("An unexpected error occurred."));
        }
    }

    private void validateFile(MultipartFile file, String expectedContentType) {
        if (file.isEmpty()) {
            throw new ErrorResponseException("File is empty.");
        }
        if (!file.getContentType().equals(expectedContentType)) {
            throw new ErrorResponseException("Invalid file type. Expected: " + expectedContentType);
        }
    }
}