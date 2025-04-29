package hello.controller;

import hello.service.TempItemsService;
import hello.dto.DisplayOptionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/temp-items")
public class TempItemsController {

    private final TempItemsService tempItemsService;

    @Autowired
    public TempItemsController(TempItemsService tempItemsService) {
        this.tempItemsService = tempItemsService;
    }

    @GetMapping("/display-options")
    public ResponseEntity<List<DisplayOptionsDTO>> getDisplayOptions() {
        List<DisplayOptionsDTO> displayOptions = tempItemsService.retrieveDisplayOptions();
        return ResponseEntity.ok(displayOptions);
    }
}

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}