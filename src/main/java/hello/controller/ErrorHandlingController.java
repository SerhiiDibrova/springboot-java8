package hello.controller;

import hello.dto.ErrorLogRequest;
import hello.service.ErrorHandlingService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class ErrorHandlingController {

    private final ErrorHandlingService errorHandlingService;

    public ErrorHandlingController(ErrorHandlingService errorHandlingService) {
        this.errorHandlingService = errorHandlingService;
    }

    @PostMapping("/log-error")
    public ResponseEntity<String> logError(@Valid @RequestBody ErrorLogRequest errorLogRequest) {
        errorHandlingService.logError(errorLogRequest.getErrorMessage(), errorLogRequest.getErrorSeverity(), errorLogRequest.getErrorState());
        return ResponseEntity.ok("Error logged successfully");
    }
}

package hello.dto;

import javax.validation.constraints.NotNull;

public class ErrorLogRequest {

    @NotNull
    private String errorMessage;

    @NotNull
    private Integer errorSeverity;

    @NotNull
    private Integer errorState;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorSeverity() {
        return errorSeverity;
    }

    public void setErrorSeverity(Integer errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public Integer getErrorState() {
        return errorState;
    }

    public void setErrorState(Integer errorState) {
        this.errorState = errorState;
    }
}