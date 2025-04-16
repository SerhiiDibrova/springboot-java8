

package hello.service;

import hello.repository.Table10Repository;
import hello.service.Func0Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class Proc30Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc30Service.class);

    private final Func0Service func0Service;
    private final Table10Repository table10Repository;

    @Autowired
    public Proc30Service(Func0Service func0Service, Table10Repository table10Repository) {
        this.func0Service = func0Service;
        this.table10Repository = table10Repository;
    }

    public void insertRecord(int inputParam) {
        if (inputParam < 0) {
            LOGGER.error("Invalid input parameter: {}", inputParam);
            throw new IllegalArgumentException("Input parameter must be non-negative");
        }

        try {
            String name = func0Service.generateName(inputParam);
            LocalDateTime currentDateTime = LocalDateTime.now();
            table10Repository.insertRecord(name, currentDateTime);
            LOGGER.info("Record inserted successfully");
        } catch (Exception e) {
            LOGGER.error("Error inserting record", e);
            throw new RuntimeException("Error inserting record", e);
        }
    }
}