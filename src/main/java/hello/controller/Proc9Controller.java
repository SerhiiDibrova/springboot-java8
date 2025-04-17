

package hello.controller;

import hello.service.Proc9Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proc9")
public class Proc9Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc9Controller.class);

    private final Proc9Service proc9Service;

    @Autowired
    public Proc9Controller(Proc9Service proc9Service) {
        this.proc9Service = proc9Service;
    }

    @RequestMapping
    public ResponseEntity<String> proc9(@RequestParam Integer input) {
        if (input == null) {
            LOGGER.error("Input is null");
            return new ResponseEntity<>("Input is null", HttpStatus.BAD_REQUEST);
        }
        try {
            String result = proc9Service.proc9(input);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error occurred during proc9Service.proc9(input) method call", e);
            return new ResponseEntity<>("Error occurred during proc9Service.proc9(input) method call", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}