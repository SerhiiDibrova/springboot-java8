package hello.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static ResponseEntity<Map<String, Object>> successResponse(Object data, String message, int status_code, Map<String, String> headers) {
        if (headers == null) {
            headers = new HashMap<>();
        }
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("success", true);
        if (message != null) {
            payload.put("message", message);
        }
        if (data != null) {
            payload.put("data", data);
        }
        HttpStatus status;
        try {
            status = HttpStatus.valueOf(status_code);
        } catch (IllegalArgumentException e) {
            status = HttpStatus.OK;
        }
        ResponseEntity.BodyBuilder responseBuilder = ResponseEntity.status(status).body(payload);
        headers.forEach(responseBuilder::header);
        return responseBuilder.build();
    }
}