

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class Proc39Service {

    private static final Logger LOGGER = Logger.getLogger(Proc39Service.class.getName());

    @Autowired
    private Proc39Repository proc39Repository;

    public void insertRecord() {
        try {
            String name = func9();
            if (name == null || name.isEmpty()) {
                LOGGER.warning("Generated name is empty");
                return;
            }
            Proc39Record record = new Proc39Record(UUID.randomUUID(), name, LocalDateTime.now());
            proc39Repository.save(record);
            LOGGER.info("Record inserted successfully");
        } catch (Exception e) {
            LOGGER.severe("Error inserting record: " + e.getMessage());
        }
    }

    private String func9() {
        // Implement the actual logic for generating the name
        // For demonstration purposes, a simple concatenation of the current date and time is used
        return LocalDateTime.now().toString();
    }
}