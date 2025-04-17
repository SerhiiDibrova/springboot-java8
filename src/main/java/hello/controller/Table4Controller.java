

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/table4", method = RequestMethod.GET)
public class Table4Controller {

    private final Table4Service table4Service;

    @Autowired
    public Table4Controller(Table4Service table4Service) {
        this.table4Service = table4Service;
    }

    @RequestMapping("/name")
    public ResponseEntity<String> getName(@RequestParam Integer id) {
        if (id == null) {
            return new ResponseEntity<>("Id cannot be null", HttpStatus.BAD_REQUEST);
        }
        String name = table4Service.getName(id);
        if (name == null) {
            return new ResponseEntity<>("Name not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<String> insertRecord(@RequestParam Integer inputParam) {
        if (inputParam == null) {
            return new ResponseEntity<>("Input parameter cannot be null", HttpStatus.BAD_REQUEST);
        }
        try {
            table4Service.insertRecord(inputParam);
            return new ResponseEntity<>("Record inserted successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error inserting record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}