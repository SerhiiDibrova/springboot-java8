package hello.controller;

import hello.service.TempItemsService;
import hello.model.DisplayOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temp-items")
public class TempItemsController {

    private final TempItemsService tempItemsService;

    public TempItemsController(TempItemsService tempItemsService) {
        this.tempItemsService = tempItemsService;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> insertTempItems(@RequestParam Integer orderId, @RequestBody String xmlData) {
        if (orderId == null || xmlData == null || xmlData.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid input parameters.");
        }
        try {
            tempItemsService.insertTempItems(orderId, xmlData);
            return ResponseEntity.ok("Temp items inserted successfully.");
        } catch (Exception e) {
            // logger.error("Error inserting temp items", e);
            return ResponseEntity.status(500).body("Error inserting temp items: " + e.getMessage());
        }
    }

    @PostMapping("/generate")
    public ResponseEntity<List<DisplayOptions>> generate(@RequestParam Integer orderId) {
        if (orderId == null || orderId <= 0) {
            return ResponseEntity.badRequest().build();
        }
        try {
            List<DisplayOptions> displayOptions = tempItemsService.generateDisplayOptions(orderId);
            return ResponseEntity.ok(displayOptions);
        } catch (Exception e) {
            // logger.error("Error generating display options", e);
            return ResponseEntity.status(500).build();
        }
    }
}