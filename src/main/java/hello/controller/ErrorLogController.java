package hello.controller;

import hello.service.ErrorLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Min;

@Validated
@RestController
public class ErrorLogController {

    private final ErrorLogService errorLogService;
    private static final Logger logger = LoggerFactory.getLogger(ErrorLogController.class);

    public ErrorLogController(ErrorLogService errorLogService) {
        this.errorLogService = errorLogService;
    }

    @PostMapping("/error/log")
    public ResponseEntity<String> handleError(@RequestParam @NotBlank String errorMessage, 
                                              @RequestParam @Min(1) int errorSeverity, 
                                              @RequestParam @Min(0) int errorState) {
        try {
            errorLogService.logError(errorMessage, errorSeverity, errorState);
            return ResponseEntity.ok("Error logged successfully");
        } catch (IllegalArgumentException e) {
            logger.error("Invalid input: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error logging failed: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error logging failed: " + e.getMessage());
        }
    }
}