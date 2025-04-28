package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ErrorResponseUtil {

    /**
     * Constructs a standardized error response for client communication.
     *
     * @param errors    Any error details that need to be included in the response.
     * @param message   A message that provides additional context about the error.
     * @param statusCode Specifies the HTTP status code to be returned in the response.
     * @param headers   Additional headers to be included in the response.
     * @return A ResponseEntity containing the error response.
     */
    public static ResponseEntity<Map<String, Object>> errorResponse(Object errors, String message, HttpStatus statusCode, Map<String, String> headers) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("success", false);
        if (message != null) {
            payload.put("message", message);
        }
        if (errors != null) {
            payload.put("errors", errors);
        }
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(statusCode).body(Collections.unmodifiableMap(payload));
        if (headers != null) {
            headers.forEach(responseBuilder::header);
        }
        return responseBuilder.build();
    }
}