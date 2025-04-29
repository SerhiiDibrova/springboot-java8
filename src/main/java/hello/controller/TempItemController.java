package hello.controller;

import hello.service.TempItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

@RestController
public class TempItemController {

    private final TempItemService tempItemService;

    public TempItemController(TempItemService tempItemService) {
        this.tempItemService = tempItemService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/temp-items")
    public ResponseEntity<Void> createTempItem(@RequestParam Integer orderId, @RequestBody String xmlData) {
        if (orderId == null || xmlData == null || xmlData.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        tempItemService.insertTempItems(orderId, xmlData);
        return ResponseEntity.ok().build();
    }
}

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler({ParserConfigurationException.class, SAXException.class, IOException.class})
    public ResponseEntity<String> handleXmlParsingExceptions(Exception ex) {
        return ResponseEntity.badRequest().body("XML parsing error: " + ex.getMessage());
    }
}