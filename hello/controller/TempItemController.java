package hello.controller;

import hello.service.TempItemService;
import hello.dto.DisplayOptionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temp-items")
public class TempItemController {

    private final TempItemService tempItemService;

    @Autowired
    public TempItemController(TempItemService tempItemService) {
        this.tempItemService = tempItemService;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/display-options")
    public ResponseEntity<List<DisplayOptionsDTO>> getDisplayOptions() {
        try {
            List<DisplayOptionsDTO> displayOptions = tempItemService.retrieveDisplayOptions();
            return ResponseEntity.ok(displayOptions);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}