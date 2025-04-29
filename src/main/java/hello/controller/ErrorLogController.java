package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import hello.service.ErrorLogService;
import hello.dto.ErrorLogDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Validated
public class ErrorLogController {

    private static final Logger logger = LoggerFactory.getLogger(ErrorLogController.class);

    @Autowired
    private ErrorLogService errorLogService;

    @PostMapping("/error/log")
    public ResponseEntity<String> logError(@RequestBody @Validated ErrorLogDTO errorLogDTO) {
        try {
            errorLogService.logError(errorLogDTO);
            return new ResponseEntity<>("Error logged successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            logger.error("Validation error: {}", e.getMessage());
            return new ResponseEntity<>("Invalid error log data", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("Error logging failed: {}", e.getMessage());
            return new ResponseEntity<>("Error logging failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}