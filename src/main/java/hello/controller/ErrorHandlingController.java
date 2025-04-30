package hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.ErrorHandlingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ErrorHandlingController {

    private final ErrorHandlingService errorHandlingService;
    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingController.class);

    public ErrorHandlingController(ErrorHandlingService errorHandlingService) {
        this.errorHandlingService = errorHandlingService;
    }

    @PostMapping("/perform-operation")
    public ResponseEntity<String> performOperation() {
        try {
            String response = errorHandlingService.handleError();
            return ResponseEntity.ok(response);
        } catch (SpecificException1 e) {
            logger.error("Specific error occurred: {}", e.getMessage());
            return ResponseEntity.status(400).body("Specific error: " + e.getMessage());
        } catch (SpecificException2 e) {
            logger.error("Another specific error occurred: {}", e.getMessage());
            return ResponseEntity.status(404).body("Not found: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An unexpected error occurred: {}", e.getMessage());
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
}