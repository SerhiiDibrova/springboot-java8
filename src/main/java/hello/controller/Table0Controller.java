

package hello.controller;

import hello.entity.Table0Entity;
import hello.service.Table0Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table0")
public class Table0Controller {

    private final Table0Service table0Service;

    public Table0Controller(Table0Service table0Service) {
        this.table0Service = table0Service;
    }

    @PostMapping
    @RequestMapping("/insert")
    public Table0Entity insertRecord(@RequestBody Table0Entity entity) {
        return table0Service.insertRecord(entity);
    }
}