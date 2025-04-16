

package hello.controller;

import hello.service.Proc1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Proc1Controller {

    @Autowired
    private Proc1Service proc1Service;

    @PostMapping(value = "/executeProc1", consumes = "application/json")
    public ResponseEntity<String> executeProc1(@RequestBody(required = true) int input) {
        try {
            if (input < 0) {
                return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
            }
            proc1Service.executeProc1(input);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}