

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/trigger8")
public class Trigger8Controller {

    private final Trigger8Service trigger8Service;

    @Autowired
    public Trigger8Controller(Trigger8Service trigger8Service) {
        this.trigger8Service = trigger8Service;
    }

    @PostMapping("/{id}")
    public void triggerProcedure(@PathVariable Integer id) {
        trigger8Service.executeProcedureAfterInsert(id);
    }
}