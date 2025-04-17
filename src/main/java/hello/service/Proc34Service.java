

package hello.service;

import hello.repository.Table14Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Service
public class Proc34Service {

    @Autowired
    private Table14Repository table14Repository;

    public String proc34(int input) {
        Assert.isTrue(input > 0, "Input must be a positive integer");
        String name = func_4(input);
        try {
            table14Repository.insert(name, LocalDateTime.now());
        } catch (Exception e) {
            throw new RuntimeException("Failed to insert record into table_14", e);
        }
        return name;
    }

    private String func_4(int input) {
        return "name_" + input;
    }
}