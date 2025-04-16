

package hello.service;

import hello.model.NameEntity;
import hello.repository.NameRepository;
import hello.service.NameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class Proc1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc1Service.class);

    @Autowired
    private NameService nameService;

    @Autowired
    private NameRepository nameRepository;

    public void executeProc1(int input) {
        if (input <= 0) {
            LOGGER.error("Invalid input: {}", input);
            throw new IllegalArgumentException("Input must be a positive integer");
        }

        try {
            String name = nameService.getNameById(input);
            if (name == null) {
                LOGGER.error("Name not found for input: {}", input);
                throw new RuntimeException("Name not found");
            }

            NameEntity nameEntity = new NameEntity();
            nameEntity.setName(name);
            nameEntity.setCreatedDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            nameRepository.save(nameEntity);
            LOGGER.info("Proc1 executed successfully for input: {}", input);
        } catch (Exception e) {
            LOGGER.error("Error executing proc1 for input: {}", input, e);
            throw new RuntimeException("Error executing proc1", e);
        }
    }
}