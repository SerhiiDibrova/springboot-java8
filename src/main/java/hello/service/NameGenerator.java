

package hello.service;

import hello.service.NameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NameGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(NameGenerator.class);
    private final NameService nameService;

    public NameGenerator(NameService nameService) {
        this.nameService = nameService;
    }

    public String generateName(int id) {
        if (id <= 0) {
            LOGGER.error("Invalid id: {}", id);
            throw new IllegalArgumentException("Id must be a positive integer");
        }

        try {
            String name = nameService.getNameById(id);
            if (name == null || name.isEmpty()) {
                LOGGER.error("Name not found for id: {}", id);
                throw new RuntimeException("Name not found");
            }
            return name;
        } catch (Exception e) {
            LOGGER.error("Error generating name for id: {}", id, e);
            throw new RuntimeException("Error generating name", e);
        }
    }
}