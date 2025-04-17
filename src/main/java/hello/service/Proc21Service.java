

package hello.service;

import hello.repository.Table1Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class Proc21Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc21Service.class);

    private final Table1Repository table1Repository;

    @Autowired
    public Proc21Service(Table1Repository table1Repository) {
        if (table1Repository == null) {
            throw new NullPointerException("Table1Repository cannot be null");
        }
        this.table1Repository = table1Repository;
    }

    public void insertData(Integer input) {
        if (input == null) {
            LOGGER.error("Input cannot be null");
            throw new NullPointerException("Input cannot be null");
        }
        try {
            String stringValue = func_1(input);
            LocalDateTime currentDateTime = getCurrentDateTime();
            table1Repository.insertData(stringValue, currentDateTime);
        } catch (Exception e) {
            LOGGER.error("Error inserting data", e);
            throw new RuntimeException("Error inserting data", e);
        }
    }

    private String func_1(Integer input) {
        return "String value for input: " + input;
    }

    private LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
}