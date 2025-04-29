package hello.controller;

import hello.service.ErrorHandlingService;
import hello.dto.ErrorLogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandlingController {

    @Autowired
    private ErrorHandlingService errorHandlingService;

    @PostMapping("/log-error")
    public ResponseEntity<String> logError(@RequestBody ErrorLogDTO errorLogDTO) {
        if (errorLogDTO.getErrorMessage() == null || errorLogDTO.getErrorMessage().isEmpty()) {
            return ResponseEntity.badRequest().body("Error message cannot be empty");
        }
        try {
            errorHandlingService.logError(errorLogDTO.getErrorMessage(), errorLogDTO.getErrorSeverity(), errorLogDTO.getErrorState());
            return ResponseEntity.ok("Error logged successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to log error");
        }
    }
}