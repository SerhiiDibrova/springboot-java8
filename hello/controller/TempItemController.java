package hello.controller;

import hello.service.TempItemService;
import hello.model.TempItem;
import hello.model.DisplayOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temp-items")
public class TempItemController {

    @Autowired
    private TempItemService tempItemService;

    @PostMapping("/populate")
    public ResponseEntity<String> populateTempItems(@RequestBody List<TempItem> tempItems) {
        try {
            tempItemService.populateTempItems(tempItems);
            return ResponseEntity.ok("TempItems populated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error populating TempItems: " + e.getMessage());
        }
    }

    @GetMapping("/display-options")
    public ResponseEntity<List<DisplayOptions>> getDisplayOptions() {
        try {
            List<DisplayOptions> displayOptions = tempItemService.getDisplayOptions();
            return ResponseEntity.ok(displayOptions);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(List.of());
        }
    }
}