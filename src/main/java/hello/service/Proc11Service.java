

package hello.service;

import hello.entity.Table11Entity;
import hello.repository.Table11Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Proc11Service {

    private final Table11Repository table11Repository;

    @Autowired
    public Proc11Service(Table11Repository table11Repository) {
        this.table11Repository = table11Repository;
    }

    public void insertRecord(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException("Input parameter cannot be null");
        }
        String strValue = func_1(input);
        Table11Entity entity = new Table11Entity(input, strValue, LocalDateTime.now());
        try {
            table11Repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting record into table_11", e);
        }
    }

    private String func_1(Integer input) {
        // implement func_1 logic here
        // for demonstration purposes, a simple logic is implemented
        if (input % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }
}