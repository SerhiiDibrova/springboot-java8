

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Table9Controller {

    private final Table9Service table9Service;

    @Autowired
    public Table9Controller(Table9Service table9Service) {
        this.table9Service = table9Service;
    }

    @GetMapping("/name")
    public String getName(@RequestParam Integer id) {
        return table9Service.getName(id);
    }
}