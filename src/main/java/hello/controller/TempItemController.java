package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import hello.service.TempItemService;
import hello.model.TempItem;

import java.util.List;

@RestController
@RequestMapping("/api/temp-items")
public class TempItemController {

    @Autowired
    private TempItemService tempItemService;

    @GetMapping
    public ResponseEntity<List<TempItem>> getAllTempItems() {
        List<TempItem> tempItems = tempItemService.getAllTempItems();
        return ResponseEntity.ok(tempItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TempItem> getTempItemById(@PathVariable Long id) {
        TempItem tempItem = tempItemService.getTempItemById(id);
        if (tempItem == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(tempItem);
    }

    @PostMapping
    public ResponseEntity<TempItem> createTempItem(@RequestBody TempItem tempItem) {
        if (tempItem == null || tempItem.getName() == null || tempItem.getName().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        TempItem createdTempItem = tempItemService.createTempItem(tempItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTempItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TempItem> updateTempItem(@PathVariable Long id, @RequestBody TempItem tempItem) {
        if (tempItem == null || tempItem.getName() == null || tempItem.getName().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        TempItem updatedTempItem = tempItemService.updateTempItem(id, tempItem);
        if (updatedTempItem == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedTempItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTempItem(@PathVariable Long id) {
        if (!tempItemService.deleteTempItem(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }
}