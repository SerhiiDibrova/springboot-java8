package hello.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import hello.service.BService;

@RestController
public class BController {

    private final BService bService;

    @Autowired
    public BController(BService bService) {
        this.bService = bService;
    }

    @GetMapping("/method_b")
    public String methodB() {
        return bService.callMethodB();
    }
}