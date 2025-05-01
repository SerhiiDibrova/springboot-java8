package hello.controller;

import hello.service.ErrorHandlingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandlingController {

    private final ErrorHandlingService errorHandlingService;

    public ErrorHandlingController(ErrorHandlingService errorHandlingService) {
        this.errorHandlingService = errorHandlingService;
    }

    @PostMapping("/performDatabaseOperation")
    public ResponseEntity<String> performDatabaseOperation() {
        try {
            errorHandlingService.handleDatabaseOperation(() -> {
                // Example database operation logic
                // For instance, saving an entity to the database
                // entityRepository.save(new Entity());
            });
            return ResponseEntity.ok("Database operation completed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while performing the database operation.");
        }
    }
}