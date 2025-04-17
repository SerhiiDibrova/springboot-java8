

package hello.controller;

import hello.service.Proc6Service;
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

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/proc_6")
public class Proc6Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc6Controller.class);

    private final Proc6Service proc6Service;

    @Autowired
    public Proc6Controller(Proc6Service proc6Service) {
        this.proc6Service = proc6Service;
    }

    @PostMapping
    public ResponseEntity<String> insertRecord(@NotNull @RequestParam Integer input) {
        try {
            proc6Service.insertRecord("table_6", input);
            LOGGER.info("Record inserted successfully");
            return new ResponseEntity<>("Record inserted successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Invalid input", e);
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            LOGGER.error("Error inserting record", e);
            return new ResponseEntity<>("Error inserting record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}