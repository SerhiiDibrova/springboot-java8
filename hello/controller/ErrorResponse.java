package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Controller
@Validated
public class ErrorResponseController {

    @GetMapping("/error")
    public ResponseEntity<Map<String, Object>> errorResponse(
            @NotNull @RequestParam("status") HttpStatus status,
            @NotBlank @RequestParam("message") String message,
            @NotBlank @RequestParam("details") String details) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", message);
        error.put("details", details);
        return new ResponseEntity<>(error, status);
    }
}