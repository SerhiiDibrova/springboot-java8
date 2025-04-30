package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.service.TempItemService;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.InputSource;
import java.io.StringReader;

@RestController
public class TempItemController {

    @Autowired
    private TempItemService tempItemService;

    @PostMapping("/temp-items")
    public ResponseEntity<String> insertTempItems(@RequestBody String xmlData, @RequestParam Integer orderId) {
        if (xmlData == null || !isWellFormedXML(xmlData) || orderId == null) {
            throw new BadRequestException("Invalid XML data or order ID");
        }
        try {
            String result = tempItemService.insertTempItems(xmlData, orderId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new BadRequestException("Error processing request: " + e.getMessage());
        }
    }

    @GetMapping("/display-options")
    public ResponseEntity<Object> getDisplayOptions() {
        return ResponseEntity.ok(tempItemService.retrieveDisplayOptions());
    }

    private boolean isWellFormedXML(String xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(new InputSource(new StringReader(xmlData)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}