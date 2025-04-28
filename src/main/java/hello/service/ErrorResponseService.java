package hello.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.Optional;

public class ErrorResponseService {

    /**
     * Constructs an error response with the specified parameters.
     *
     * @param errors    Optional object containing error details.
     * @param message   Optional string containing a message.
     * @param statusCode Integer representing the HTTP status code.
     * @param headers   Optional map containing HTTP headers.
     * @return ResponseEntity containing the error response.
     */
    public ResponseEntity<Map<String, Object>> errorResponse(Optional<Object> errors, Optional<String> message, Integer statusCode, Optional<Map<String, String>> headers) {
        Map<String, Object> payload = new java.util.HashMap<>();
        payload.put("success", false);
        
        message.ifPresent(msg -> payload.put("message", msg));
        errors.ifPresent(err -> payload.put("errors", err));
        
        int effectiveStatusCode = (statusCode != null && HttpStatus.resolve(statusCode) != null) ? statusCode : HttpStatus.INTERNAL_SERVER_ERROR.value();
        ResponseEntity.ResponseEntityBuilder<Map<String, Object>> responseBuilder = ResponseEntity.status(effectiveStatusCode).body(payload);
        
        headers.ifPresent(hdrs -> hdrs.forEach(responseBuilder::header));
        
        return responseBuilder.build();
    }
}