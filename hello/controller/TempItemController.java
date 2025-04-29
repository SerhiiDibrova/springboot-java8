package hello.controller;

import hello.service.TempItemService;
import hello.model.TempItem;
import hello.config.CustomConfig;
import hello.config.LegacyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/temp-items")
public class TempItemController {

    @Autowired
    private TempItemService tempItemService;

    @PostMapping
    public ResponseEntity<TempItem> createTempItem(@Valid @RequestBody TempItem tempItem) {
        try {
            TempItem createdTempItem = tempItemService.createTempItem(tempItem);
            return ResponseEntity.ok(createdTempItem);
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/display-options")
    public ResponseEntity<List<Object>> getDisplayOptions() {
        try {
            List<Object> displayOptions = tempItemService.getDisplayOptions();
            return ResponseEntity.ok(displayOptions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}