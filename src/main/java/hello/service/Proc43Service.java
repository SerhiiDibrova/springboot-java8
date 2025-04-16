

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import hello.repository.Proc43Repository;
import hello.model.Table3;

@Service
public class Proc43Service {

    private final Proc43Repository proc43Repository;

    @Autowired
    public Proc43Service(Proc43Repository proc43Repository) {
        this.proc43Repository = proc43Repository;
    }

    public void createRecord(Integer input) {
        try {
            String stringValue = func3(input);
            proc43Repository.save(new Table3(stringValue, new Date()));
        } catch (Exception e) {
            // handle exception
        }
    }

    private String func3(Integer input) {
        // implementation of func3 method
        return "string value associated with " + input;
    }
}