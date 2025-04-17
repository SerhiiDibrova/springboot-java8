

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.service.Proc24Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
public class Proc24Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc24Controller.class);

    @Autowired
    private Proc24Service proc24Service;

    @GetMapping("/proc24")
    public ResponseEntity<String> getProc24Result(@NotNull @Min(0) @RequestParam("input") int input) {
        try {
            String result = proc24Service.executeProc24(input);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error executing proc24", e);
            return new ResponseEntity<>("Error executing proc24", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}