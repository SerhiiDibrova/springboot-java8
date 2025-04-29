package hello.controller;

import hello.service.TempItemsService;
import hello.entity.DisplayOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api/temp-items")
public class TempItemsController {

    @Autowired
    private TempItemsService tempItemsService;

    @GetMapping("/display-options")
    public ResponseEntity<List<DisplayOptions>> getDisplayOptions(@RequestParam String module) {
        try {
            List<DisplayOptions> displayOptions = tempItemsService.getDisplayOptions(module);
            if (displayOptions.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(displayOptions);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}