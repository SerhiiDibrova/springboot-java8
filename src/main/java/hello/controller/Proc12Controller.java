

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

@RestController
public class Proc12Controller {

    private final Proc12Service proc12Service;
    private static final Logger LOGGER = Logger.getLogger(Proc12Controller.class.getName());

    @Autowired
    public Proc12Controller(Proc12Service proc12Service) {
        this.proc12Service = proc12Service;
    }

    @GetMapping("/insertRecord")
    public ResponseEntity<String> insertRecord(@NotNull @RequestParam Integer input) {
        try {
            proc12Service.insertRecord(input);
            return new ResponseEntity<>("Record inserted successfully", HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.severe("Error inserting record: " + e.getMessage());
            return new ResponseEntity<>("Error inserting record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getName")
    public ResponseEntity<String> getName(@NotNull @RequestParam Integer input) {
        try {
            String name = proc12Service.func_2(input);
            return new ResponseEntity<>(name, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.severe("Error getting name: " + e.getMessage());
            return new ResponseEntity<>("Error getting name", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}