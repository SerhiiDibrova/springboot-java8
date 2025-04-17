

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.Table8Repository;
import hello.model.Table8Entity;
import java.util.Date;
import java.util.logging.Logger;

@Service
public class Table8Service {

    private static final Logger LOGGER = Logger.getLogger(Table8Service.class.getName());

    @Autowired
    private Table8Repository table8Repository;

    public String getNameById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        Table8Entity entity = table8Repository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
        return entity.getName();
    }

    public void insertData(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        try {
            String stringValue = table8Repository.func_8(input);
            Table8Entity entity = new Table8Entity(stringValue, input, new Date());
            table8Repository.save(entity);
            LOGGER.info("Data inserted successfully");
        } catch (Exception e) {
            LOGGER.severe("Error inserting data: " + e.getMessage());
            throw new RuntimeException("Error inserting data", e);
        }
    }
}