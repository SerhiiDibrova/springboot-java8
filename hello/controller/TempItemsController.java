package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.TempItemsService;

@RestController
@RequestMapping("/api/temp-items")
public class TempItemsController {

    private final TempItemsService tempItemsService;

    @Autowired
    public TempItemsController(TempItemsService tempItemsService) {
        this.tempItemsService = tempItemsService;
    }

    @GetMapping("/display-options")
    public ResponseEntity<Object> getDisplayOptions() {
        Object displayOptions = tempItemsService.getDisplayOptions();
        return ResponseEntity.ok(displayOptions);
    }
}