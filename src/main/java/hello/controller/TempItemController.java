package hello.controller;

import hello.dto.TempItemDTO;
import hello.service.TempItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

@RestController
@RequestMapping("/temp-items")
public class TempItemController {

    private final TempItemService tempItemService;

    public TempItemController(TempItemService tempItemService) {
        this.tempItemService = tempItemService;
    }

    @PostMapping
    public ResponseEntity<?> createTempItem(@Valid @RequestBody TempItemDTO tempItemDTO) {
        try {
            tempItemService.insertTempItems(tempItemDTO.getOrderId(), tempItemDTO.getXmlData());
            return ResponseEntity.ok().build();
        } catch (ValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (ServiceException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Service error: " + e.getMessage());
        }
    }
}

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
    }
}