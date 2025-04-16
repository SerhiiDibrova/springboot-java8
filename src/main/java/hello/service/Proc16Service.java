

package hello.service;

import hello.model.Proc16Entity;
import hello.repository.NameRepository;
import hello.service.NameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Proc16Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc16Service.class);

    @Autowired
    private NameService nameService;

    @Autowired
    private NameRepository nameRepository;

    public Proc16Entity processProc16(int input) {
        if (input <= 0) {
            LOGGER.error("Invalid input: {}", input);
            throw new IllegalArgumentException("Input must be a positive integer");
        }

        try {
            String name = nameService.getNameById(input);
            Proc16Entity proc16Entity = new Proc16Entity(input, name, LocalDateTime.now());
            return nameRepository.save(proc16Entity);
        } catch (Exception e) {
            LOGGER.error("Error processing proc16", e);
            throw new RuntimeException("Error processing proc16", e);
        }
    }
}