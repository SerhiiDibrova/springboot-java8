

package hello.controller;

import hello.service.Proc18Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proc18")
public class Proc18Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc18Controller.class);

    private final Proc18Service proc18Service;

    @Autowired
    public Proc18Controller(Proc18Service proc18Service) {
        this.proc18Service = proc18Service;
    }

    @PostMapping("/insert")
    public ResponseEntity<String> createRecord(@RequestParam Integer input) {
        try {
            proc18Service.insertRecord(input);
            return new ResponseEntity<>("Record inserted successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Error inserting record", e);
            return new ResponseEntity<>("Error inserting record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}