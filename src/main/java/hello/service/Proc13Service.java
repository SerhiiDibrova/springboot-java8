

package hello.service;

import hello.service.NameService;
import hello.repository.NameRepository;
import hello.entity.NameEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Proc13Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc13Service.class);

    private final NameService nameService;
    private final NameRepository nameRepository;

    public Proc13Service(NameService nameService, NameRepository nameRepository) {
        this.nameService = nameService;
        this.nameRepository = nameRepository;
    }

    public void insertName(Integer id) {
        if (id == null) {
            LOGGER.error("Input parameter id is null");
            return;
        }

        try {
            String name = nameService.getNameById(id);
            if (name == null || name.isEmpty()) {
                LOGGER.error("Name value is null or empty for id: {}", id);
                return;
            }

            NameEntity nameEntity = new NameEntity(name);
            nameRepository.save(nameEntity);
            LOGGER.info("New record inserted into table_13 with id: {}", id);
        } catch (Exception e) {
            LOGGER.error("Error occurred during insertName method execution", e);
        }
    }
}