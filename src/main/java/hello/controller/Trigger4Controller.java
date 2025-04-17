

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
public class Trigger4Controller {

    private static final Logger LOGGER = Logger.getLogger(Trigger4Controller.class.getName());

    private final Trigger4Service trigger4Service;

    @Autowired
    public Trigger4Controller(Trigger4Service trigger4Service) {
        this.trigger4Service = trigger4Service;
    }

    @PostMapping("/trigger_4")
    public ResponseEntity<String> handleInsert(@NotNull @RequestParam Integer id) {
        try {
            trigger4Service.executeTrigger(id);
            return new ResponseEntity<>("Trigger executed successfully", HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.severe("Error executing trigger: " + e.getMessage());
            return new ResponseEntity<>("Error executing trigger", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}