package hello.controller;

import hello.service.ErrorHandlingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    private final ErrorHandlingService errorHandlingService;

    public ErrorController(ErrorHandlingService errorHandlingService) {
        this.errorHandlingService = errorHandlingService;
    }

    @GetMapping("/error/trigger")
    public ResponseEntity<String> triggerError() {
        try {
            throw new RuntimeException("Intentional error for testing");
        } catch (Exception e) {
            errorHandlingService.handleError(e);
            return ResponseEntity.status(500).body("An error has occurred");
        }
    }
}