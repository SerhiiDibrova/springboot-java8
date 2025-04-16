

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Record;
import hello.service.TriggerService;
import hello.util.Logger;

@RestController
public class TriggerController {

    @Autowired
    private TriggerService triggerService;

    @PostMapping("/insertRecord")
    public ResponseEntity<String> insertRecord(@RequestBody Record record) {
        try {
            triggerService.insertRecord(record);
            return new ResponseEntity<>("Record inserted successfully", HttpStatus.OK);
        } catch (Exception e) {
            Logger.error("Error inserting record", e);
            return new ResponseEntity<>("Error inserting record", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}