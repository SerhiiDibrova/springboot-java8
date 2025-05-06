package hello.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static ResponseEntity<Map<String, Object>> successResponse(Object data, String message, int statusCode, Map<String, String> headers) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", statusCode);
        if (message != null) {
            responseBody.put("message", message);
        }
        if (data != null) {
            responseBody.put("data", data);
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        if (headers != null) {
            headers.forEach(responseHeaders::add);
        }

        return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.valueOf(statusCode));
    }
}