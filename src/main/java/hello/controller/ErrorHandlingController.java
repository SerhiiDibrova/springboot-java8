package hello.controller;

import hello.service.ErrorHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandlingController {

    private final ErrorHandlingService errorHandlingService;

    @Autowired
    public ErrorHandlingController(ErrorHandlingService errorHandlingService) {
        this.errorHandlingService = errorHandlingService;
    }

    @PostMapping("/error/test")
    public ResponseEntity<Void> handleErrorEndpoint() {
        errorHandlingService.handleError();
        return ResponseEntity.ok().build();
    }
}