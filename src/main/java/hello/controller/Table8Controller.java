

package hello.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;
import hello.service.Table8Service;
import hello.exception.Table8Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class Table8Controller {

    private static final Logger logger = LoggerFactory.getLogger(Table8Controller.class);

    @Autowired
    private Table8Service table8Service;

    @GetMapping("/getNameById")
    public ResponseEntity<String> getNameById(@NotNull @PathVariable Integer id) {
        try {
            String name = table8Service.getNameById(id);
            return new ResponseEntity<>(name, HttpStatus.OK);
        } catch (Table8Exception e) {
            logger.error("Error getting name by id", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/insertData")
    public ResponseEntity<Void> insertData(@NotNull @RequestParam Integer input) {
        try {
            table8Service.insertData(input);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Table8Exception e) {
            logger.error("Error inserting data", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}