package hello.controller;

import hello.service.ErrorHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandlingController {

    @Autowired
    private ErrorHandlingService errorHandlingService;

    @PostMapping("/api/errors/log")
    public ResponseEntity<String> logError(@RequestParam String errorMessage,
                                            @RequestParam Integer errorSeverity,
                                            @RequestParam Integer errorState) {
        if (errorMessage == null || errorMessage.isEmpty()) {
            return ResponseEntity.badRequest().body("Error message is required");
        }
        if (errorSeverity == null || errorSeverity < 0) {
            return ResponseEntity.badRequest().body("Error severity must be a non-negative integer");
        }
        if (errorState == null || errorState < 0) {
            return ResponseEntity.badRequest().body("Error state must be a non-negative integer");
        }
        errorHandlingService.handleError(errorMessage, errorSeverity, errorState);
        return ResponseEntity.ok("Error logged successfully");
    }
}