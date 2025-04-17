

package hello.controller;

import hello.dto.Proc35RequestDTO;
import hello.service.Proc35Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Proc35Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc35Controller.class);

    private final Proc35Service proc35Service;

    @Autowired
    public Proc35Controller(Proc35Service proc35Service) {
        this.proc35Service = proc35Service;
    }

    @PostMapping("/proc35")
    public ResponseEntity<String> createRecord(@RequestBody Proc35RequestDTO request) {
        if (request == null || request.getInput() == null) {
            LOGGER.error("Invalid request: request or input is null");
            return ResponseEntity.badRequest().build();
        }

        try {
            proc35Service.createRecord(request.getInput());
            LOGGER.info("Record created successfully");
            return ResponseEntity.ok("Record created successfully");
        } catch (Exception e) {
            LOGGER.error("Error creating record", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}