

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.service.TempItemService;
import hello.util.XmlValidator;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
public class TempItemController {

    private static final Logger LOGGER = Logger.getLogger(TempItemController.class.getName());

    @Autowired
    private TempItemService tempItemService;

    @PostMapping("/insertTempItemFromXml")
    public ResponseEntity<String> insertTempItem(@RequestParam @Valid Long orderId, @RequestParam @Valid String xmlDocument) {
        if (orderId == null || orderId <= 0) {
            return new ResponseEntity<>("Order ID must be a positive number", HttpStatus.BAD_REQUEST);
        }

        if (xmlDocument == null || xmlDocument.isEmpty()) {
            return new ResponseEntity<>("XML document cannot be empty", HttpStatus.BAD_REQUEST);
        }

        if (!XmlValidator.isValidXml(xmlDocument)) {
            return new ResponseEntity<>("Invalid XML document", HttpStatus.BAD_REQUEST);
        }

        try {
            tempItemService.insertTempItemFromXml(orderId, xmlDocument);
            return new ResponseEntity<>("Temp item inserted successfully", HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.severe("Error inserting temp item: " + e.getMessage());
            return new ResponseEntity<>("Error inserting temp item", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}