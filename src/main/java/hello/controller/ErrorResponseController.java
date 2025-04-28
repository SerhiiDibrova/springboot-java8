package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ErrorResponseController {

    public ResponseEntity<Map<String, Object>> errorResponse(Optional<Object> errors, Optional<String> message, int statusCode, Optional<Map<String, String>> headers) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("success", false);
        
        message.ifPresent(msg -> payload.put("message", msg));
        
        errors.ifPresent(err -> payload.put("errors", jsonableEncoder(err)));
        
        ResponseEntity<Map<String, Object>> responseEntity = new ResponseEntity<>(payload, HttpStatus.valueOf(statusCode));
        
        headers.ifPresent(h -> responseEntity.getHeaders().setAll(h));
        
        return responseEntity;
    }

    private Object jsonableEncoder(Object errors) {
        if (errors instanceof Map) {
            return new HashMap<>((Map<?, ?>) errors);
        } else if (errors instanceof Iterable) {
            return errors;
        } else {
            return errors.toString();
        }
    }
}