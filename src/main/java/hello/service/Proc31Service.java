

package hello.service;

import hello.repository.Table11Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class Proc31Service {

    private final Table11Repository table11Repository;
    private final Logger logger = Logger.getLogger(Proc31Service.class.getName());

    @Autowired
    public Proc31Service(Table11Repository table11Repository) {
        this.table11Repository = table11Repository;
    }

    public String getName(Integer id) {
        try {
            return func_1(id);
        } catch (Exception e) {
            logger.severe("Error occurred while calling func_1: " + e.getMessage());
            return null;
        }
    }

    public void insertIntoTable11(Integer id, String name) {
        try {
            table11Repository.save(new Table11(id, name, LocalDateTime.now()));
        } catch (Exception e) {
            logger.severe("Error occurred while inserting into table_11: " + e.getMessage());
        }
    }

    private String func_1(Integer id) {
        // implement func_1 logic here
        // for demonstration purposes, assume func_1 is an external function
        // that returns a string value based on the input id
        // in a real-world scenario, this would be replaced with the actual implementation
        return "name_" + id;
    }
}