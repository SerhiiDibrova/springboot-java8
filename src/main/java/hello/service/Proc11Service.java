

package hello.service;

import hello.entity.NameEntity;
import hello.repository.NameRepository;
import hello.service.NameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class Proc11Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc11Service.class);

    private final NameService nameService;
    private final NameRepository nameRepository;

    @Autowired
    public Proc11Service(NameService nameService, NameRepository nameRepository) {
        if (nameService == null || nameRepository == null) {
            throw new NullPointerException("NameService and NameRepository instances cannot be null");
        }
        this.nameService = nameService;
        this.nameRepository = nameRepository;
    }

    public void executeProc11(int id) {
        if (id <= 0) {
            LOGGER.error("Invalid id: {}", id);
            throw new IllegalArgumentException("Id must be a positive integer");
        }
        try {
            String name = nameService.getNameById(id);
            if (name == null) {
                LOGGER.error("Name not found for id: {}", id);
                throw new RuntimeException("Name not found");
            }
            NameEntity nameEntity = new NameEntity(id, name, LocalDateTime.now());
            nameRepository.save(nameEntity);
        } catch (Exception e) {
            LOGGER.error("Error saving NameEntity", e);
            throw new RuntimeException("Error saving NameEntity", e);
        }
    }
}