package hello.controller;

import hello.service.ErrorHandlingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandlingController {

    private final ErrorHandlingService errorHandlingService;

    public ErrorHandlingController(ErrorHandlingService errorHandlingService) {
        this.errorHandlingService = errorHandlingService;
    }

    @PostMapping("/execute-error-handling")
    public String executeErrorHandling() {
        errorHandlingService.executeWithErrorHandling();
        return "Error handling has been executed";
    }
}