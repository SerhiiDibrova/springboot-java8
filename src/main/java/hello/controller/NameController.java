

package hello.controller;

import hello.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

    private final NameService nameService;

    @Autowired
    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/name/{id}")
    public String getNameById(@PathVariable Integer id) {
        return nameService.getNameById(id);
    }

    @GetMapping("/name/insert/{input}")
    public String insertName(@PathVariable("input") Integer input) {
        return nameService.insertName(input);
    }
}