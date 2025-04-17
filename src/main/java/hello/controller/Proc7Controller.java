

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.dto.Proc7ResponseDTO;
import hello.service.Proc7Service;

@RestController
@RequestMapping(value = "/proc7", produces = "application/json")
public class Proc7Controller {

    @Autowired
    private Proc7Service proc7Service;

    @GetMapping
    public Proc7ResponseDTO getNameById(@RequestParam(required = true) Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        return proc7Service.getNameById(id);
    }
}