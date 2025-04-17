

package hello.service;

import hello.entity.Table8Entity;
import hello.repository.Table8Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class Proc8Service {

    private final Table8Repository table8Repository;

    @Autowired
    public Proc8Service(Table8Repository table8Repository) {
        this.table8Repository = table8Repository;
    }

    @Transactional
    public Table8Entity proc8(int input) {
        try {
            Table8Entity entity = new Table8Entity();
            entity.setName(func_8(input));
            entity.setCreatedAt(LocalDateTime.now());
            return table8Repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred during database operation", e);
        }
    }

    private String func_8(int input) {
        // implement func_8 logic here
        // for demonstration purposes, a simple logic is implemented
        if (input > 0) {
            return "Positive number";
        } else if (input < 0) {
            return "Negative number";
        } else {
            return "Zero";
        }
    }
}