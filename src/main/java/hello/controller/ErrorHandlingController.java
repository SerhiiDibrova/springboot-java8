package hello.controller;

import hello.dto.ErrorLogDTO;
import hello.service.ErrorHandlingService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping("/error/log")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> handleErrorEndpoint(@Valid @RequestBody ErrorLogDTO errorLogDTO) {
        errorHandlingService.handleError(new Exception(errorLogDTO.getErrorMessage()));
        return ResponseEntity.noContent().build();
    }
}