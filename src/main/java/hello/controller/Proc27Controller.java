

package hello.controller;

import hello.entity.Table7;
import hello.service.Proc27Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Proc27Controller {

    private final Proc27Service proc27Service;

    @Autowired
    public Proc27Controller(Proc27Service proc27Service) {
        this.proc27Service = proc27Service;
    }

    public Table7 createRecord(Integer input) {
        return proc27Service.createRecord(input);
    }
}