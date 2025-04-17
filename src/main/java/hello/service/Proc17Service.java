

package hello.service;

import hello.dto.Table17DTO;
import hello.repository.Table17Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Proc17Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc17Service.class);

    private final Table17Repository table17Repository;

    @Autowired
    public Proc17Service(Table17Repository table17Repository) {
        this.table17Repository = table17Repository;
    }

    public void insertRecord(Integer input) {
        if (input == null) {
            LOGGER.error("Input parameter is null");
            throw new IllegalArgumentException("Input parameter cannot be null");
        }

        Table17DTO table17DTO = new Table17DTO();
        table17DTO.setName(getNameForInput(input));
        try {
            table17Repository.save(table17DTO);
        } catch (Exception e) {
            LOGGER.error("Error inserting record into table_17", e);
            throw new RuntimeException("Error inserting record into table_17", e);
        }
    }

    private String getNameForInput(Integer input) {
        // implement logic to retrieve string value for name column based on input
        // for example:
        return "Name for input " + input;
    }
}