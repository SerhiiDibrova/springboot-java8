

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

@RestController
public class Proc36Controller {

    private static final Logger LOGGER = Logger.getLogger(Proc36Controller.class.getName());
    private final Proc36Service proc36Service;

    @Autowired
    public Proc36Controller(Proc36Service proc36Service) {
        this.proc36Service = proc36Service;
    }

    @PostMapping("/create-record")
    public ResponseEntity<String> createRecord(@NotNull @RequestParam Integer input) {
        try {
            proc36Service.createRecord("table_16", input);
            return new ResponseEntity<>("Record created successfully", HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.severe("Failed to create record: " + e.getMessage());
            return new ResponseEntity<>("Failed to create record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}