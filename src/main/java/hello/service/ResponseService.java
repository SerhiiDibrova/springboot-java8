package hello.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Optional;

public class ResponseService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ResponseEntity<Map<String, Object>> success_response(Object data, String message, int statusCode, Map<String, String> headers) {
        if (data == null) data = null;
        if (message == null) message = null;
        if (headers == null) headers = Map.of();

        Map<String, Object> payload = new java.util.HashMap<>();
        payload.put("success", true);
        
        if (message != null) {
            payload.put("message", message);
        }
        
        if (data != null) {
            payload.put("data", objectMapper.convertValue(data, Map.class));
        }
        
        HttpHeaders httpHeaders = Optional.ofNullable(headers).map(HttpHeaders::new).orElse(new HttpHeaders());
        return new ResponseEntity<>(payload, httpHeaders, HttpStatus.valueOf(statusCode == 0 ? HttpStatus.OK.value() : statusCode));
    }
}