package hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import hello.service.XMLConversionService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class XMLConversionController {

    private final XMLConversionService xmlConversionService;

    @Autowired
    public XMLConversionController(XMLConversionService xmlConversionService) {
        this.xmlConversionService = xmlConversionService;
    }

    @PostMapping("/xml2json")
    public CompletableFuture<ResponseEntity<?>> convertXmlToJson(@RequestParam("file") MultipartFile file) {
        if (file.getContentType() == null || !file.getContentType().equals("text/xml")) {
            return CompletableFuture.completedFuture(ResponseEntity.badRequest().body("Invalid file type. Please upload an XML file."));
        }
        return CompletableFuture.supplyAsync(() -> {
            try {
                String jsonResult = xmlConversionService.convertXmlToJson(file);
                return ResponseEntity.ok(jsonResult);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body("Validation error: " + e.getMessage());
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the file: " + e.getMessage());
            }
        });
    }
}