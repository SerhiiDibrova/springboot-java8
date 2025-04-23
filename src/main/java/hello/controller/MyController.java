package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    private final MyClass myClass;

    @Autowired
    public MyController(MyClass myClass) {
        this.myClass = myClass;
    }

    @GetMapping
    public ResponseEntity<String> methodA() {
        try {
            String result = myClass.methodA();
            if (result == null) {
                LOGGER.error("methodA returned null");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            LOGGER.error("Error calling methodA", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}