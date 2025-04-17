

package hello.controller;

import hello.service.Proc4Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.logging.Level;

@RestController
@RequestMapping("/proc4")
public class Proc4Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc4Controller.class);

    private final Proc4Service proc4Service;

    @Autowired
    public Proc4Controller(Proc4Service proc4Service) {
        this.proc4Service = proc4Service;
    }

    @RequestMapping(value = "/execute", method = RequestMethod.GET)
    public ResponseEntity<String> executeProc(@RequestParam @Min(1) int input) {
        try {
            proc4Service.executeProc(input);
            return new ResponseEntity<>("Proc4 executed successfully", HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error executing Proc4", e);
            return new ResponseEntity<>("Error executing Proc4", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}