package hello.controller;

import hello.service.TempItemService;
import hello.model.DisplayOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TempItemController {

    private final TempItemService tempItemService;

    public TempItemController(TempItemService tempItemService) {
        this.tempItemService = tempItemService;
    }

    @PostMapping("/temp-items")
    public ResponseEntity<String> insertTempItems(@RequestParam Integer orderId, @RequestBody String xmlData) {
        if (!isValidXml(xmlData)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid XML data");
        }
        try {
            tempItemService.insertTempItems(orderId, xmlData);
            return ResponseEntity.ok("TempItem inserted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting TempItem");
        }
    }

    @GetMapping("/temp-items/display-options")
    public ResponseEntity<List<DisplayOptions>> getDisplayOptions() {
        try {
            List<DisplayOptions> displayOptions = tempItemService.retrieveDisplayOptions();
            return ResponseEntity.ok(displayOptions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(List.of());
        }
    }

    private boolean isValidXml(String xmlData) {
        try {
            javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new java.io.ByteArrayInputStream(xmlData.getBytes()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}