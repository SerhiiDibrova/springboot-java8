package hello.controller;

import hello.dto.ErrorLogDTO;
import hello.service.ErrorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@ControllerAdvice
public class ErrorLogController {

    private final ErrorLogService errorLogService;
    private static final Logger logger = LoggerFactory.getLogger(ErrorLogController.class);

    @Autowired
    public ErrorLogController(ErrorLogService errorLogService) {
        this.errorLogService = errorLogService;
    }

    @PostMapping("/log-error")
    public ResponseEntity<String> logError(@RequestBody ErrorLogDTO errorLogDTO) {
        if (errorLogDTO == null || errorLogDTO.getMessage() == null || errorLogDTO.getTimestamp() == null) {
            return ResponseEntity.badRequest().body("Invalid error log data");
        }
        try {
            errorLogService.logError(errorLogDTO);
            logger.info("Error logged successfully: {}", errorLogDTO);
            return ResponseEntity.ok("Error logged successfully");
        } catch (Exception e) {
            logger.error("Error logging failed: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error logging failed");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("Unhandled exception: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }
}