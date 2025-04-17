

package hello.controller;

import hello.service.InsertDataFromXmlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.logging.Level;

@RestController
public class InsertDataFromXmlController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InsertDataFromXmlController.class);

    @Autowired
    private InsertDataFromXmlService insertDataFromXmlService;

    @PostMapping("/insertDataFromXml")
    public ResponseEntity<String> insertDataFromXml(@Valid @RequestBody String xmlDocument, @Valid @RequestParam Long orderId) {
        try {
            insertDataFromXmlService.insertDataFromXml(xmlDocument, orderId);
            LOGGER.info("Data inserted successfully");
            return new ResponseEntity<>("Data inserted successfully", HttpStatus.OK);
        } catch (NullPointerException e) {
            LOGGER.error("NullPointerException occurred", e);
            return new ResponseEntity<>("Error inserting data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException e) {
            LOGGER.error("IllegalArgumentException occurred", e);
            return new ResponseEntity<>("Error inserting data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            LOGGER.error("Exception occurred", e);
            return new ResponseEntity<>("Error inserting data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException e) {
        LOGGER.error("NullPointerException occurred", e);
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        LOGGER.error("IllegalArgumentException occurred", e);
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        LOGGER.error("Exception occurred", e);
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}