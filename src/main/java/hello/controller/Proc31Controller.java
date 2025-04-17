

package hello.controller;

import hello.dto.Proc31RequestDTO;
import hello.service.Proc31Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Proc31Controller {

    private final Proc31Service proc31Service;

    @Autowired
    public Proc31Controller(Proc31Service proc31Service) {
        this.proc31Service = proc31Service;
    }

    @PostMapping("/proc31")
    public ResponseEntity<?> proc31(@RequestBody Proc31RequestDTO request) {
        return ResponseEntity.ok(proc31Service.execute(request));
    }
}