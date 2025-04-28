package hello.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public class ResponseService {

    public static ResponseEntity<Map<String, Object>> successResponse(Object data, String message, Integer statusCode, Map<String, String> headers) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("success", true);
        if (message != null) {
            payload.put("message", message);
        }
        if (data != null) {
            payload.put("data", data);
        }
        
        HttpHeaders responseHeaders = new HttpHeaders();
        if (headers != null) {
            headers.forEach(responseHeaders::set);
        }
        
        int finalStatusCode = (statusCode != null) ? statusCode : HttpStatus.OK.value();
        return new ResponseEntity<>(payload, responseHeaders, HttpStatus.valueOf(finalStatusCode));
    }
}