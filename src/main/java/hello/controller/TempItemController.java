package hello.controller;

import hello.service.TempItemService;
import hello.declaration.GlobalExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class TempItemController {

    private final TempItemService tempItemService;

    public TempItemController(TempItemService tempItemService) {
        this.tempItemService = tempItemService;
    }

    @PostMapping("/temp-items")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> insertTempItems(@RequestParam @Valid Integer orderId, @RequestBody String xmlData) {
        if (xmlData.length() > 1048576) {
            return ResponseEntity.badRequest().build();
        }
        tempItemService.insertTempItems(orderId, xmlData);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/display-options")
    public ResponseEntity<?> retrieveDisplayOptions() {
        return ResponseEntity.ok(tempItemService.retrieveDisplayOptions());
    }
}