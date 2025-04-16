

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Proc16Entity;
import hello.service.Proc16Service;

@RestController
public class Proc16Controller {

    @Autowired
    private Proc16Service proc16Service;

    @PostMapping(value = "/proc16", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Proc16Entity> proc16(@RequestBody int input) {
        Proc16Entity result = proc16Service.proc16(input);
        return ResponseEntity.ok(result);
    }
}