

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proc46")
public class Proc46Controller {

    private final Proc46Service proc46Service;

    @Autowired
    public Proc46Controller(Proc46Service proc46Service) {
        this.proc46Service = proc46Service;
    }

    @RequestMapping("/insertRecord")
    public void insertRecord(@RequestParam Integer input) {
        proc46Service.insertRecord(input);
    }
}