

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

@RestController
@RequestMapping("/proc21")
public class Proc21Controller {

    private final Proc21Service proc21Service;
    private static final Logger LOGGER = Logger.getLogger(Proc21Controller.class.getName());

    @Autowired
    public Proc21Controller(Proc21Service proc21Service) {
        this.proc21Service = proc21Service;
    }

    @RequestMapping("/insertData")
    public ResponseEntity<String> insertData(@NotNull @RequestParam Integer input) {
        try {
            proc21Service.insertData(input);
            return new ResponseEntity<>("Data inserted successfully", HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.severe("Error inserting data: " + e.getMessage());
            return new ResponseEntity<>("Error inserting data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}