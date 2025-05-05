package hello.controller;

import hello.service.TemporaryItemsService;
import hello.dto.DisplayOptionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemporaryItemsController {

    @Autowired
    private TemporaryItemsService temporaryItemsService;

    @GetMapping("/temporary-items/display-options")
    public ResponseEntity<List<DisplayOptionsDTO>> getDisplayOptions() {
        try {
            List<DisplayOptionsDTO> displayOptions = temporaryItemsService.retrieveDisplayOptions();
            return ResponseEntity.ok(displayOptions);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}