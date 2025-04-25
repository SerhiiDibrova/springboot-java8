package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SuccessResponse {

    private Map<String, Object> responseJson;
    private ObjectMapper objectMapper;

    public SuccessResponse() {
        this.responseJson = new ConcurrentHashMap<>();
        this.objectMapper = new ObjectMapper();
    }

    public SuccessResponse(User user) {
        this();
    }

    public ResponseEntity<Map<String, Object>> successResponse(Object responseData) {
        responseJson.put("success", true);
        if (responseData != null) {
            try {
                String encodedData = objectMapper.writeValueAsString(responseData);
                responseJson.put("data", encodedData);
            } catch (Exception e) {
                responseJson.put("error", "Failed to encode data");
                return new ResponseEntity<>(responseJson, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(responseJson, HttpStatus.OK);
    }

    public ResponseEntity<String> successResponse(List<User> users) {
        if (users == null) {
            return new ResponseEntity<>("[]", HttpStatus.OK);
        }
        try {
            String json = objectMapper.writeValueAsString(users);
            return new ResponseEntity<>(json, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to encode data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}