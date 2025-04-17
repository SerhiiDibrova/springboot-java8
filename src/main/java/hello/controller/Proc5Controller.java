

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class Proc5Controller {

    private final Proc5Service proc5Service;

    @Autowired
    public Proc5Controller(Proc5Service proc5Service) {
        this.proc5Service = proc5Service;
    }

    @PostMapping("/proc5")
    public ResponseEntity<Void> execute(@Valid @NotNull @RequestBody Proc5Request request) {
        try {
            proc5Service.execute(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}