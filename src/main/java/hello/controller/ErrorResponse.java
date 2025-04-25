package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;

public class ErrorResponseGenerator {
    private String message;
    private HttpStatus statusCode;

    public ErrorResponseGenerator(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public ResponseEntity<MappingJacksonValue> errorResponse(Object errors, HttpStatus statusCode) {
        ObjectMapper mapper = new ObjectMapper();
        MappingJacksonValue responseJson = new MappingJacksonValue("{\"success\": false}");
        if (errors != null) {
            try {
                responseJson = new MappingJacksonValue("{\"success\": false, \"errors\": " + mapper.writeValueAsString(errors) + "}");
            } catch (Exception e) {
                responseJson = new MappingJacksonValue("{\"success\": false, \"errors\": \"Error occurred while processing request\"}");
            }
        }
        return new ResponseEntity<>(responseJson, statusCode);
    }

    public ErrorResponse errorResponse(String message, HttpStatus statusCode) {
        return new ErrorResponse(message, statusCode);
    }
}