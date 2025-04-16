

package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class Table8Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table8Service.class);

    @Autowired
    private NameRetrievalService nameRetrievalService;

    @Autowired
    private EntityManager entityManager;

    public void insertRecord(Integer inputParameter) {
        if (inputParameter == null) {
            LOGGER.error("Input parameter is null");
            throw new IllegalArgumentException("Input parameter cannot be null");
        }

        try {
            String name = nameRetrievalService.getName(inputParameter);
            if (name == null || name.isEmpty()) {
                LOGGER.error("Name retrieved from NameRetrievalService is null or empty");
                throw new IllegalArgumentException("Name cannot be null or empty");
            }

            Table8Record record = new Table8Record(name);
            entityManager.persist(record);
            LOGGER.info("Record inserted successfully");
        } catch (Exception e) {
            LOGGER.error("Error inserting record", e);
            throw new RuntimeException("Error inserting record", e);
        }
    }
}