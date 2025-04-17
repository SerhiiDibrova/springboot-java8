

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Trigger6Controller {

    private final Trigger6Service trigger6Service;

    @Autowired
    public Trigger6Controller(Trigger6Service trigger6Service) {
        this.trigger6Service = trigger6Service;
    }

    @PostMapping("/trigger_6")
    public void executeProc6(@RequestParam Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        try {
            trigger6Service.executeProc6(id);
        } catch (Exception e) {
            throw new RuntimeException("Error executing proc_6 procedure", e);
        }
    }
}