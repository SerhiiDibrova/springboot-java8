

package hello.controller;

import hello.service.Proc8Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class Proc8Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc8Controller.class);

    @Autowired
    private Proc8Service proc8Service;

    @RequestMapping("/proc8")
    @ResponseBody
    public ResponseEntity<String> proc8(@RequestParam("input") Integer input) {
        if (input == null) {
            LOGGER.error("Input parameter is missing");
            return new ResponseEntity<>("Input parameter is missing", HttpStatus.BAD_REQUEST);
        }

        try {
            String result = proc8Service.executeProc8(input);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error executing proc8Service", e);
            return new ResponseEntity<>("Error executing proc8Service", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}