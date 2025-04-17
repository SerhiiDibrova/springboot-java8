

package hello.controller;

import hello.dto.InputDTO;
import hello.service.Proc40Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Proc40Controller {

    private final Proc40Service proc40Service;

    @Autowired
    public Proc40Controller(Proc40Service proc40Service) {
        this.proc40Service = proc40Service;
    }

    @PostMapping("/proc40")
    public ResponseEntity<String> execute(@RequestBody InputDTO inputDTO) {
        if (inputDTO == null) {
            log.error("InputDTO is null");
            return new ResponseEntity<>("Invalid input", HttpStatus.BAD_REQUEST);
        }
        try {
            proc40Service.execute(inputDTO);
            return new ResponseEntity<>("Operation successful", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error executing proc40", e);
            return new ResponseEntity<>("Operation failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}