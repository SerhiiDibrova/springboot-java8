package hello.controller;

import hello.service.TempItemService;
import hello.exception.XmlParsingException;
import hello.exception.DataIntegrityException;
import hello.dto.DisplayOptionsDTO;
import hello.service.ErrorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TempItemController {

    @Autowired
    private TempItemService tempItemService;

    @PostMapping("/temp-items")
    public ResponseEntity<List<DisplayOptionsDTO>> insertTempItems(@RequestParam Integer orderId, @RequestBody String xmlData) {
        if (orderId == null || xmlData == null || !isValidXml(xmlData)) {
            return ResponseEntity.badRequest().body("Invalid input parameters.");
        }
        try {
            tempItemService.populateTempItems(orderId, xmlData);
            List<DisplayOptionsDTO> displayOptions = tempItemService.combineResults();
            return ResponseEntity.status(HttpStatus.CREATED).body(displayOptions);
        } catch (XmlParsingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("XML parsing error: " + e.getMessage());
        } catch (DataIntegrityException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data integrity error: " + e.getMessage());
        } catch (Exception e) {
            ErrorLogService.handleError(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    private boolean isValidXml(String xmlData) {
        // Implement XML validation logic here
        return true; // Placeholder for actual validation
    }
}