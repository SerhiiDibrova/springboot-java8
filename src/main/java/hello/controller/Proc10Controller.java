

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.service.Proc10Service;

@RestController
@RequestMapping("/proc10")
public class Proc10Controller {

    private final Proc10Service proc10Service;

    @Autowired
    public Proc10Controller(Proc10Service proc10Service) {
        this.proc10Service = proc10Service;
    }

    @GetMapping
    public String execute(@RequestParam("input") int input) {
        try {
            if (input < 0) {
                throw new IllegalArgumentException("Input must be a non-negative integer");
            }
            return proc10Service.execute(input);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}