package hello.controller;

import hello.dto.ErrorLogDTO;
import hello.service.ErrorLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class ErrorLogController {

    private final ErrorLogService errorLogService;

    public ErrorLogController(ErrorLogService errorLogService) {
        this.errorLogService = errorLogService;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/error/log")
    public ResponseEntity<Void> logError(@Valid @RequestBody ErrorLogDTO errorLogDTO) {
        try {
            errorLogService.logError(errorLogDTO.getErrorMessage(), errorLogDTO.getErrorSeverity(), errorLogDTO.getErrorState());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("Validation error: " + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}