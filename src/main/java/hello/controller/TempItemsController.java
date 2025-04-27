package hello.controller;

import hello.service.TempItemsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempItemsController {

    private static final Logger logger = LoggerFactory.getLogger(TempItemsController.class);

    @Autowired
    private TempItemsService tempItemsService;

    @PostMapping("/temp-items")
    public ResponseEntity<String> processTempItems() {
        try {
            String result = tempItemsService.processTempItems();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Error processing temp items", e);
            return ResponseEntity.status(500).body("Error processing temp items");
        }
    }
}

package hello.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class TempItemsService {

    public String processTempItems() {
        // Implementation of processing logic
        return "Temp items processed successfully";
    }

    public List<String> getDisplayOptions() {
        return Arrays.asList("Option1", "Option2", "Option3");
    }
}