package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.Optional;

public class ResponseUtil {

    public static ResponseEntity<Map<String, Object>> success_response(Object data, String message, int statusCode, Map<String, String> headers) {
        Map<String, Object> payload = Map.of("success", true);
        
        if (message != null) {
            payload.put("message", message);
        } else {
            payload.put("message", "Operation successful");
        }
        
        if (data != null) {
            payload.put("data", data);
        }
        
        if (statusCode <= 0) {
            statusCode = HttpStatus.OK.value();
        }
        
        ResponseEntity.ResponseEntityBuilder<Map<String, Object>> responseBuilder = ResponseEntity.status(statusCode).body(payload);
        
        Optional.ofNullable(headers).ifPresent(responseBuilder::headers);
        
        return responseBuilder.build();
    }

    public static ResponseEntity<Map<String, Object>> error_response(String message, int statusCode) {
        Map<String, Object> payload = Map.of("success", false, "message", message != null ? message : "An error occurred");
        return ResponseEntity.status(statusCode > 0 ? statusCode : HttpStatus.INTERNAL_SERVER_ERROR.value()).body(payload);
    }
}