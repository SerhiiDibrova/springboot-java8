package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class MyController {

    private final MyService myService;
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/methodA")
    public ResponseEntity<String> methodA() {
        try {
            String result = myService.methodA();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while calling methodA", e);
            return new ResponseEntity<>("Error occurred while calling methodA", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}