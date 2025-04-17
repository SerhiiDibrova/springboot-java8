

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Proc39Controller {

    private final Proc39Service proc39Service;

    @Autowired
    public Proc39Controller(Proc39Service proc39Service) {
        this.proc39Service = proc39Service;
    }

    @PostMapping("/record")
    public ResponseEntity<?> createRecord(@Valid @RequestParam Integer input) {
        try {
            Optional<?> record = proc39Service.createRecord(input);
            if (record.isPresent()) {
                return new ResponseEntity<>(record.get(), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}