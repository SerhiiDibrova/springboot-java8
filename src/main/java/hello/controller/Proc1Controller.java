

package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

@RestController
@RequestMapping("/proc1")
public class Proc1Controller {

    private static final Logger LOGGER = Logger.getLogger(Proc1Controller.class.getName());

    @RequestMapping(method = RequestMethod.GET, produces = "text/plain")
    public ResponseEntity<String> executeProc1(@NotNull @RequestParam Integer input) {
        try {
            if (input == null || input.isEmpty()) {
                LOGGER.severe("Input is null or empty");
                return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
            }
            String result = "Proc1 executed with input: " + input;
            LOGGER.info(result);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.severe("Error executing Proc1: " + e.getMessage());
            return new ResponseEntity<>("Error executing Proc1", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}