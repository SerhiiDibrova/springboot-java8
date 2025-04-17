

package hello.controller;

import hello.service.Proc43Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/proc43")
@Validated
public class Proc43Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc43Controller.class);

    private final Proc43Service proc43Service;

    @Autowired
    public Proc43Controller(Proc43Service proc43Service) {
        this.proc43Service = proc43Service;
    }

    @PostMapping("/createRecord")
    public ResponseEntity<Void> createRecord(@NotNull @RequestParam Integer input) {
        try {
            proc43Service.createRecord(input);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            LOGGER.error("Error creating record", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}