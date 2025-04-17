

package hello.controller;

import hello.service.Proc30Service;
import hello.model.Table10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proc30")
public class Proc30Controller {

    @Autowired
    private Proc30Service proc30Service;

    @PostMapping("/insertRecord/{input}")
    @ResponseBody
    public ResponseEntity<Table10> insertRecord(@PathVariable Integer input) {
        return ResponseEntity.ok(proc30Service.insertRecord(input));
    }
}