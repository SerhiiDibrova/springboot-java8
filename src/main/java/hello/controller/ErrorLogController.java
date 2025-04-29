package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/error-logs")
public class ErrorLogController {

    private final ErrorLogService errorLogService;

    @Autowired
    public ErrorLogController(ErrorLogService errorLogService) {
        this.errorLogService = errorLogService;
    }

    @PostMapping
    public ResponseEntity<Void> logError(@Valid @RequestBody ErrorLogDTO errorLogDTO) {
        if (isValidErrorLog(errorLogDTO)) {
            errorLogService.logError(errorLogDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    private boolean isValidErrorLog(ErrorLogDTO errorLogDTO) {
        return errorLogDTO != null && errorLogDTO.getMessage() != null && !errorLogDTO.getMessage().isEmpty();
    }
}