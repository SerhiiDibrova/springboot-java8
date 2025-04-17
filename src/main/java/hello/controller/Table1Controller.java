

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class Table1Controller {

    private final Table1Service table1Service;

    @Autowired
    public Table1Controller(Table1Service table1Service) {
        this.table1Service = table1Service;
    }

    @PostMapping("/insertRecord")
    public ResponseEntity<String> insertRecord(@NotNull @RequestParam Integer input) {
        try {
            table1Service.insertRecord(input);
            return new ResponseEntity<>("Record inserted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error inserting record: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}