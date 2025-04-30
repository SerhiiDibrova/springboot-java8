package hello.controller;

import hello.service.TempItemService;
import hello.model.DisplayOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TempItemController {

    @Autowired
    private TempItemService tempItemService;

    @PostMapping("/temp-items/create")
    public ResponseEntity<Void> createTempItems() {
        try {
            tempItemService.createTempItems();
            return ResponseEntity.ok().build();
        } catch (MissingTableException e) {
            return ResponseEntity.status(400).build();
        } catch (MissingColumnException e) {
            return ResponseEntity.status(400).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/temp-items")
    public ResponseEntity<Void> insertTempItems(@RequestParam Integer orderId, @Valid @RequestBody @Size(max = 10000) String xmlData) {
        try {
            tempItemService.insertTempItems(orderId, xmlData);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/temp-items/retrieve")
    public ResponseEntity<List<DisplayOptions>> retrieveDisplayOptions() {
        List<DisplayOptions> options = tempItemService.retrieveDisplayOptions();
        return ResponseEntity.ok(options);
    }
}