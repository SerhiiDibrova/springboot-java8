

package hello.controller;

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
@RequestMapping(value = "/proc19", method = RequestMethod.POST)
public class Proc19Controller {

    private final Proc19Service proc19Service;

    @Autowired
    public Proc19Controller(Proc19Service proc19Service) {
        this.proc19Service = proc19Service;
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertRecord(@NotNull @RequestParam Integer input) {
        try {
            proc19Service.insertRecord(input);
            return new ResponseEntity<>("Record inserted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error inserting record: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}