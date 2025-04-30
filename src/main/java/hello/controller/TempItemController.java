package hello.controller;

import hello.service.TempItemService;
import hello.dto.TempItemDTO;
import hello.dto.DisplayOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/temp-items")
public class TempItemController {

    private final TempItemService tempItemService;

    public TempItemController(TempItemService tempItemService) {
        this.tempItemService = tempItemService;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> insertTempItem(@Valid @RequestBody TempItemDTO tempItemDTO) {
        try {
            tempItemService.insertTempItem(tempItemDTO);
            return ResponseEntity.ok("Insertion successful");
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation failed: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Insertion failed: " + e.getMessage());
        }
    }

    @GetMapping("/report")
    public ResponseEntity<List<DisplayOptions>> generateReport() {
        try {
            List<DisplayOptions> report = tempItemService.generateTempItemsReport();
            return ResponseEntity.ok(report);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}