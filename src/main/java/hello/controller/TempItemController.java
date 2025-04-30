package hello.controller;

import hello.service.DisplayOptionsService;
import hello.service.TempItemService;
import hello.model.DisplayOptions;
import hello.model.TempItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/temp-items")
@Validated
public class TempItemController {

    private final TempItemService tempItemService;
    private final DisplayOptionsService displayOptionsService;

    @Autowired
    public TempItemController(TempItemService tempItemService, DisplayOptionsService displayOptionsService) {
        this.tempItemService = tempItemService;
        this.displayOptionsService = displayOptionsService;
    }

    @PostMapping
    public ResponseEntity<String> createTempItems(@RequestBody @Valid TempItemRequest request) {
        try {
            tempItemService.populateTempItems(request.getOrderId(), request.getXmlData());
            return ResponseEntity.ok("Temporary items created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating temporary items");
        }
    }

    @GetMapping("/display-options")
    public ResponseEntity<List<DisplayOptions>> getDisplayOptions() {
        List<DisplayOptions> options = displayOptionsService.getDisplayOptions();
        return ResponseEntity.ok(options);
    }

    @ControllerAdvice
    public static class GlobalExceptionHandler {
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation error: " + ex.getMessage());
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleGeneralExceptions(Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
        }
    }
}