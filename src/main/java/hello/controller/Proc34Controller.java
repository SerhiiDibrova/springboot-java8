

package hello.controller;

import hello.service.Proc34Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@Slf4j
public class Proc34Controller {

    private final Proc34Service proc34Service;

    @Autowired
    public Proc34Controller(Proc34Service proc34Service) {
        this.proc34Service = proc34Service;
    }

    @GetMapping("/proc34")
    public ResponseEntity<String> executeProc34(@NotNull @Min(1) @RequestParam("input") int input) {
        try {
            String result = proc34Service.execute(input);
            log.info("Proc34 executed successfully with input: {}", input);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            log.error("Error executing Proc34 with input: {}", input, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error executing Proc34");
        }
    }
}