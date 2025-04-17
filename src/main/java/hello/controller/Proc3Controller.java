

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proc3")
public class Proc3Controller {

    private final Proc3Service proc3Service;

    @Autowired
    public Proc3Controller(Proc3Service proc3Service) {
        this.proc3Service = proc3Service;
    }

    @RequestMapping("/name")
    public String getName(@RequestParam Integer input) {
        return proc3Service.getName(input);
    }
}