

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Table7Controller {

    private final Table7Service table7Service;

    @Autowired
    public Table7Controller(Table7Service table7Service) {
        this.table7Service = table7Service;
    }

    @Controller
    public String getName(@RequestParam Integer id) {
        return table7Service.getName(id);
    }
}