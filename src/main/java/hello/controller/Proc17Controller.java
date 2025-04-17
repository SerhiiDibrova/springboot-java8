

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
@Validated
public class Proc17Controller {

    private final Proc17Service proc17Service;

    @Autowired
    public Proc17Controller(Proc17Service proc17Service) {
        this.proc17Service = proc17Service;
    }

    @PostMapping("/insertRecord")
    public ResponseEntity<Void> insertRecord(@Valid @NotNull @RequestBody Integer input) {
        proc17Service.insertRecord(input, "table_17");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}