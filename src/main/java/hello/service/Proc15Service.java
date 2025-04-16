

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.model.Table15;
import hello.repository.Table15Repository;
import hello.service.Func5Service;
import java.util.Date;
import java.util.Optional;

@Service
public class Proc15Service {

    @Autowired
    private Func5Service func5Service;

    @Autowired
    private Table15Repository table15Repository;

    public void proc15(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer");
        }
        String name = func5Service.func5(input);
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        Table15 table15 = new Table15();
        table15.setId(input);
        table15.setName(name);
        table15.setCreatedAt(new Date());
        try {
            table15Repository.save(table15);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save Table15 object", e);
        }
    }
}