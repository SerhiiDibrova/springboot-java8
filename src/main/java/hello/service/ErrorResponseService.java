package hello.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Optional;

public class ErrorResponseService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Returns a structured error response.
     *
     * @param errors    Optional errors to include in the response
     * @param message   Optional message to include in the response
     * @param statusCode HTTP status code for the response
     * @param headers   Optional headers to include in the response
     * @return ResponseEntity containing the structured error response
     */
    public ResponseEntity<Map<String, Object>> errorResponse(Optional<Object> errors, Optional<String> message, int statusCode, Optional<Map<String, String>> headers) {
        if (statusCode < 100 || statusCode > 599) {
            throw new IllegalArgumentException("Invalid status code");
        }

        Map<String, Object> payload = new java.util.HashMap<>();
        payload.put("success", false);
        
        message.ifPresent(msg -> payload.put("message", msg));
        errors.ifPresent(err -> payload.put("errors", objectMapper.convertValue(err, Map.class)));
        
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(HttpStatus.valueOf(statusCode)).body(payload);
        headers.ifPresent(hdrs -> hdrs.forEach(responseBuilder::header));
        
        return responseBuilder.build();
    }
}