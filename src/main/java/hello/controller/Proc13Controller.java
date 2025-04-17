

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proc13")
public class Proc13Controller {

    private final Proc13Service proc13Service;

    @Autowired
    public Proc13Controller(Proc13Service proc13Service) {
        this.proc13Service = proc13Service;
    }

    @RequestMapping("/insertRecord")
    public String insertRecord(Integer input) {
        if (input == null) {
            return "Input parameter is required";
        }
        try {
            proc13Service.insertRecord(input);
            return "Record inserted successfully";
        } catch (Exception e) {
            return "Error inserting record: " + e.getMessage();
        }
    }
}