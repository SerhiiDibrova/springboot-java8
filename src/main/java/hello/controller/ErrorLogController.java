package hello.controller;

import hello.service.ErrorLogService;
import hello.dto.ErrorLogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorLogController {

    @Autowired
    private ErrorLogService errorLogService;

    @PostMapping("/error/log")
    public ResponseEntity<Void> logError(@RequestBody ErrorLogDTO errorLogDTO) {
        if (errorLogDTO.getErrorMessage() == null || errorLogDTO.getErrorMessage().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        errorLogService.logError(errorLogDTO.getErrorMessage(), errorLogDTO.getErrorSeverity(), errorLogDTO.getErrorState());
        return ResponseEntity.ok().build();
    }
}