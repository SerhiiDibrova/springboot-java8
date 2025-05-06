package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ErrorController {

    @PostMapping("/error")
    public ResponseEntity<Map<String, Object>> errorResponse(
            @RequestBody(required = false) Object errors,
            @RequestBody(required = false) String message,
            Map<String, String> headers,
            @RequestBody(required = false) Object additionalInfo) {
        
        int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        
        Map<String, Object> payload = new HashMap<>();
        payload.put("success", false);
        if (message != null) {
            payload.put("message", message);
        }
        if (errors != null) {
            try {
                payload.put("errors", new ObjectMapper().writeValueAsString(errors));
            } catch (Exception e) {
                payload.put("errors", "Error serializing errors");
            }
        }
        return new ResponseEntity<>(payload, HttpStatus.valueOf(statusCode), headers != null ? headers : new HashMap<>());
    }
}