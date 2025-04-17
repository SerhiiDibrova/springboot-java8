

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/proc20")
public class Proc20Controller {

    private final Proc20Service proc20Service;

    @Autowired
    public Proc20Controller(Proc20Service proc20Service) {
        this.proc20Service = proc20Service;
    }

    @RequestMapping("/insertTable0")
    public String insertTable0(@RequestParam Integer input) {
        proc20Service.insertTable0(input);
        return "redirect:/proc20/insertTable0";
    }
}