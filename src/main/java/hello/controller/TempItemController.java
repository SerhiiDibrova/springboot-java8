package hello.controller;

import hello.service.TempItemService;
import hello.dto.DisplayOptionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@RestController
@RequestMapping("/temp-items")
public class TempItemController {

    @Autowired
    private TempItemService tempItemService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<Void> createTempItems(@RequestBody String xmlData, @RequestParam Integer orderId) {
        validateOrderId(orderId);
        Document xmlDocument = parseXml(xmlData);
        tempItemService.insertTempItems(xmlDocument, orderId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/display-options")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<DisplayOptionsDTO>> getDisplayOptions() {
        List<DisplayOptionsDTO> displayOptions = tempItemService.retrieveDisplayOptions();
        return ResponseEntity.ok(displayOptions);
    }

    private Document parseXml(String xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new InputSource(new StringReader(xmlData)));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException("Invalid XML data", e);
        }
    }

    private void validateOrderId(Integer orderId) {
        if (orderId == null || orderId <= 0) {
            throw new IllegalArgumentException("Invalid order ID");
        }
    }
}

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}