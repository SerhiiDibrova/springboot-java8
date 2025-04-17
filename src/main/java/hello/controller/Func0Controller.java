

package hello.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;

@RestController
public class Func0Controller {

    private final Func0Service func0Service;

    public Func0Controller(Func0Service func0Service) {
        this.func0Service = func0Service;
    }

    @GetMapping("/func0")
    public ResponseEntity<Func0Response> func0(@Validated @NotNull @RequestParam Integer id) {
        try {
            Func0Response response = func0Service.func0(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}