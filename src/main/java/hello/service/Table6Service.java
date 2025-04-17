

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Table6Service {

    private final Table6Repository table6Repository;

    @Autowired
    public Table6Service(Table6Repository table6Repository) {
        this.table6Repository = table6Repository;
    }

    public String getName(Long id) {
        return table6Repository.findById(id).map(Table6Entity::getName).orElse(null);
    }

    public void insertRecord(Long input) {
        String name = func_6();
        Table6Entity entity = new Table6Entity(input, name, LocalDateTime.now());
        table6Repository.save(entity);
    }

    private String func_6() {
        // Implementation of func_6 function
        // For demonstration purposes, it returns a static string value
        // Replace this with the actual implementation of func_6
        return "Static string value";
    }
}