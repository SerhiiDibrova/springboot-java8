

package hello.service;

import hello.entity.Table9;
import hello.repository.Table9Repository;
import hello.service.Func9;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Service
public class Proc9Service {

    private final Table9Repository table9Repository;
    private final Func9 func9;

    @Autowired
    public Proc9Service(Table9Repository table9Repository, Func9 func9) {
        this.table9Repository = table9Repository;
        this.func9 = func9;
    }

    public void proc9(int input) {
        Assert.isTrue(input > 0, "Input must be a positive integer");
        try {
            String name = func9.func9(input);
            Table9 table9 = new Table9();
            table9.setId(input);
            table9.setName(name);
            table9.setCreatedAt(LocalDateTime.now());
            table9Repository.save(table9);
        } catch (Exception e) {
            throw new RuntimeException("Error executing proc9", e);
        }
    }
}