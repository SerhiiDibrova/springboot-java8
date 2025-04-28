package hello.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Optional;

public class ResponseController {

    public ResponseEntity<Map<String, Object>> success_response(Object data, String message, Integer status_code, Map<String, String> headers) {
        Map<String, Object> payload = new java.util.HashMap<>();
        payload.put("success", true);
        
        if (message != null) {
            payload.put("message", message);
        }
        
        if (data != null) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                payload.put("data", objectMapper.writeValueAsString(data));
            } catch (Exception e) {
                payload.put("data", null);
            }
        }
        
        HttpHeaders httpHeaders = Optional.ofNullable(headers).map(HttpHeaders::new).orElse(new HttpHeaders());
        int effectiveStatusCode = (status_code != null) ? status_code : HttpStatus.OK.value();
        return new ResponseEntity<>(payload, httpHeaders, HttpStatus.valueOf(effectiveStatusCode));
    }
}