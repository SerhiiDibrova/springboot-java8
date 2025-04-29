package hello.controller;

import hello.dto.ErrorLogDTO;
import hello.service.ErrorHandlingService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@RestController
@Validated
public class ErrorHandlingController {

    private final ErrorHandlingService errorHandlingService;
    private final Validator validator;

    public ErrorHandlingController(ErrorHandlingService errorHandlingService, Validator validator) {
        this.errorHandlingService = errorHandlingService;
        this.validator = validator;
    }

    @PostMapping("/error/log")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> logError(@RequestBody @Validated ErrorLogDTO errorLogDTO) {
        Set<ConstraintViolation<ErrorLogDTO>> violations = validator.validate(errorLogDTO);
        if (!violations.isEmpty()) {
            return ResponseEntity.badRequest().body("Validation failed: " + violations.iterator().next().getMessage());
        }
        try {
            errorHandlingService.handleError(errorLogDTO.getMessage(), errorLogDTO.getSeverity(), errorLogDTO.getState());
            return ResponseEntity.ok("Error logged successfully");
        } catch (SpecificException e) {
            return ResponseEntity.status(400).body("Error logging failed: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error logging failed: " + e.getMessage());
        }
    }
}