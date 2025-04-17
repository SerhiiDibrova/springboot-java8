

package hello.service;

import hello.repository.Table6Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Proc6Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc6Service.class);

    private final Table6Repository table6Repository;

    @Autowired
    public Proc6Service(Table6Repository table6Repository) {
        this.table6Repository = table6Repository;
    }

    @Transactional
    public void insertRecord(Integer input) {
        if (input == null) {
            LOGGER.error("Input parameter 'input' is null");
            throw new IllegalArgumentException("Input parameter 'input' is null");
        }

        try {
            Table6 table6 = new Table6();
            table6.setName(func_6());
            table6.setId(input);
            table6.setCreatedAt(LocalDateTime.now());
            table6Repository.save(table6);
        } catch (Exception e) {
            LOGGER.error("Error inserting record into table_6", e);
            throw new RuntimeException("Error inserting record into table_6", e);
        }
    }

    private String func_6() {
        // Implement func_6 logic here
        // For demonstration purposes, return a hardcoded value
        return "John Doe";
    }
}