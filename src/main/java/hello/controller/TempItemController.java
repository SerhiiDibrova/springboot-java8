package hello.controller;

import hello.service.TempItemService;
import hello.model.TempItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/temp-items")
@ControllerAdvice
public class TempItemController {

    private final TempItemService tempItemService;
    private static final Logger logger = LoggerFactory.getLogger(TempItemController.class);

    @Autowired
    public TempItemController(TempItemService tempItemService) {
        this.tempItemService = tempItemService;
    }

    @PostMapping
    public ResponseEntity<TempItem> createTempItem(@Valid @RequestBody TempItem tempItem) {
        try {
            TempItem createdItem = tempItemService.createTempItem(tempItem);
            return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error creating temporary item", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/display-options")
    public ResponseEntity<List<String>> getDisplayOptions() {
        try {
            List<String> displayOptions = tempItemService.getDisplayOptions();
            return new ResponseEntity<>(displayOptions, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error retrieving display options", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("An error occurred: ", e);
        return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}