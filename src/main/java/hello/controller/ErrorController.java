package hello.controller;

import hello.service.ErrorHandlingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/errors")
@Validated
public class ErrorController {

    private final ErrorHandlingService errorHandlingService;

    public ErrorController(ErrorHandlingService errorHandlingService) {
        this.errorHandlingService = errorHandlingService;
    }

    @PostMapping("/log")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> logError(@Valid @RequestBody ErrorLogRequest request) {
        try {
            errorHandlingService.handleError(request.getErrorMessage(), request.getErrorSeverity(), request.getErrorState());
            return ResponseEntity.ok("Error logged successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid error details");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to log error");
        }
    }
}

class ErrorLogRequest {
    @Size(max = 255)
    private String errorMessage;
    private int errorSeverity;
    private int errorState;

    // Getters and Setters
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(int errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public int getErrorState() {
        return errorState;
    }

    public void setErrorState(int errorState) {
        this.errorState = errorState;
    }
}