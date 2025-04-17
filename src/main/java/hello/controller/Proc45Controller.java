

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Proc45Resource {

    private final Proc45Service proc45Service;

    @Autowired
    public Proc45Resource(Proc45Service proc45Service) {
        this.proc45Service = proc45Service;
    }

    @GetMapping("/process")
    public void process(@RequestParam("input") int input) {
        try {
            proc45Service.process(input);
        } catch (Exception e) {
            // handle exception
        }
    }
}