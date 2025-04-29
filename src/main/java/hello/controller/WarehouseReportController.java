package hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class WarehouseReportController {

    @GetMapping("/response")
    public ResponseEntity<String> getResponse() {
        return new ResponseEntity<>("YES", HttpStatus.OK);
    }
}