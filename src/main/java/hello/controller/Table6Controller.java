

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/table6")
public class Table6Controller {

    private static final Logger LOGGER = Logger.getLogger(Table6Controller.class.getName());

    @Autowired
    private Table6Service table6Service;

    @GetMapping("/name")
    public ResponseEntity<String> getName(@RequestParam Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("Id cannot be null");
        }
        try {
            String name = table6Service.getName(id);
            return ResponseEntity.ok(name);
        } catch (Exception e) {
            LOGGER.severe("Error getting name: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }

    @PostMapping("/record")
    public ResponseEntity<String> insertRecord(@RequestParam Long input) {
        if (input == null) {
            return ResponseEntity.badRequest().body("Input cannot be null");
        }
        try {
            table6Service.insertRecord(input);
            return ResponseEntity.ok("Record inserted successfully");
        } catch (Exception e) {
            LOGGER.severe("Error occurred: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }
}