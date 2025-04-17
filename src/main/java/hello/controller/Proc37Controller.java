

package hello.controller;

import hello.service.Proc37Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Proc37Controller {

    private final Proc37Service proc37Service;
    private static final Logger logger = LoggerFactory.getLogger(Proc37Controller.class);

    @Autowired
    public Proc37Controller(Proc37Service proc37Service) {
        this.proc37Service = proc37Service;
    }

    @GetMapping("/createRecord")
    public ResponseEntity<String> createRecord(@RequestParam Integer input) {
        try {
            if (input == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input cannot be null");
            }
            proc37Service.createRecord(input);
            return ResponseEntity.status(HttpStatus.CREATED).body("Record created successfully");
        } catch (Exception e) {
            logger.error("Error creating record", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating record");
        }
    }
}