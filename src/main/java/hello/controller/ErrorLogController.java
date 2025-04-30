package hello.controller;

import hello.service.ErrorLogService;
import hello.dto.ErrorLogDTO;
import hello.exception.DataInsertionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/errors")
public class ErrorLogController {

    private final ErrorLogService errorLogService;

    public ErrorLogController(ErrorLogService errorLogService) {
        this.errorLogService = errorLogService;
    }

    @PostMapping("/log-error")
    public ResponseEntity<Void> logError(@Valid @RequestBody ErrorLogDTO errorLogDTO) {
        try {
            errorLogService.logError(errorLogDTO.getErrorMessage(), errorLogDTO.getErrorSeverity(), errorLogDTO.getErrorState());
            return ResponseEntity.ok().build();
        } catch (DataInsertionException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation error: " + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}