package hello.controller;

import hello.service.TempItemService;
import hello.dto.DisplayOptionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TempItemController {

    @Autowired
    private TempItemService tempItemService;

    @PostMapping("/populateTempItems")
    public ResponseEntity<String> populateTempItems() {
        tempItemService.populateTempItems();
        return ResponseEntity.ok("Temporary items populated successfully.");
    }

    @GetMapping("/displayOptions")
    public ResponseEntity<List<DisplayOptionsDTO>> getDisplayOptions() {
        List<DisplayOptionsDTO> displayOptions = tempItemService.retrieveDisplayOptions();
        return ResponseEntity.ok(displayOptions);
    }
}