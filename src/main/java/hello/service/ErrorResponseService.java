package hello.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public class ErrorResponseService {

    public ResponseEntity<Map<String, Object>> errorResponse(Object errors, String message, int statusCode, Map<String, String> headers) {
        if (statusCode <= 0) {
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
        
        Map<String, Object> payload = new HashMap<>();
        payload.put("success", false);
        
        if (message != null) {
            payload.put("message", message);
        }
        
        if (errors != null) {
            payload.put("errors", convertToJsonCompatible(errors));
        }
        
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(statusCode).body(payload);
        
        if (headers != null) {
            headers.forEach(responseBuilder::header);
        }
        
        return responseBuilder.build();
    }

    private Object convertToJsonCompatible(Object errors) {
        // Implement conversion logic here
        return errors; // Placeholder for actual conversion
    }
}