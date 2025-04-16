

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Proc24Service {

    @Autowired
    private Func4Service func4Service;

    @Autowired
    private Proc24Repository proc24Repository;

    public void insertRecord(Integer input) {
        String name = func4(input);
        proc24Repository.insertRecord(input, name, new Date());
    }

    private String func4(Integer input) {
        return func4Service.func4(input);
    }
}