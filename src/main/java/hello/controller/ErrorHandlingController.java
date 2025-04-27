package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import hello.service.ErrorHandlingService;

@RestController
public class ErrorHandlingController {

    @Autowired
    private ErrorHandlingService errorHandlingService;

    @PostMapping("/handle-error")
    public ResponseEntity<String> handleError(@RequestBody String requestBody) {
        String result = errorHandlingService.handleError(requestBody);
        return ResponseEntity.ok(result);
    }
}