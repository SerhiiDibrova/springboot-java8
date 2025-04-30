package hello.controller;

import hello.dto.TempItemDTO;
import hello.service.TempItemService;
import hello.exception.GlobalExceptionHandler;
import hello.model.DisplayOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/temp-items")
@Validated
public class TempItemController {

    private final TempItemService tempItemService;

    public TempItemController(TempItemService tempItemService) {
        this.tempItemService = tempItemService;
    }

    @PostMapping
    public ResponseEntity<String> insertTempItems(@Valid @RequestBody TempItemDTO tempItemDTO) {
        try {
            tempItemService.insertTempItems(tempItemDTO);
            return ResponseEntity.ok("Temporary item inserted successfully");
        } catch (Exception e) {
            throw new RuntimeException("Error inserting temporary item: " + e.getMessage());
        }
    }

    @PostMapping("/generate")
    public ResponseEntity<List<DisplayOptions>> generateTempItems() {
        tempItemService.generateTempItems();
        List<DisplayOptions> displayOptions = tempItemService.retrieveDisplayOptions();
        return ResponseEntity.ok(displayOptions);
    }
}

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}