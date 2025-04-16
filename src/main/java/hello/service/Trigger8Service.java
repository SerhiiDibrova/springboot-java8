

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Trigger8Service {

    private final Proc8Service proc8Service;

    @Autowired
    public Trigger8Service(Proc8Service proc8Service) {
        this.proc8Service = proc8Service;
    }

    public void executeTrigger(Table8 table8) {
        proc8Service.executeProc8(table8.getId());
    }
}