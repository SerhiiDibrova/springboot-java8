package hello.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestUtils {

    public static Optional<String> getAcceptRequestHeader(HttpRequest request) {
        if (request == null) {
            return Optional.empty();
        }
        HttpHeaders headers = request.getHeaders();
        return Optional.ofNullable(headers.getFirst("Accept"));
    }

    public static ResponseEntity<String> errorResponse(String message, HttpStatus statusCode) {
        if (message == null) {
            message = "";
        }
        return ResponseEntity.status(statusCode).body(message);
    }

    public static ResponseEntity<String> successResponse(Object responseData) throws Exception {
        if (responseData == null) {
            throw new Exception("responseData cannot be null");
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(responseData);
        return ResponseEntity.ok(json);
    }
}