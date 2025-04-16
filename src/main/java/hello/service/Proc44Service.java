

package hello.service;

import hello.entity.Table4Entity;
import hello.repository.Proc44Repository;
import hello.service.TableNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class Proc44Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc44Service.class);

    private final TableNameService tableNameService;
    private final Proc44Repository proc44Repository;

    @Autowired
    public Proc44Service(TableNameService tableNameService, Proc44Repository proc44Repository) {
        this.tableNameService = tableNameService;
        this.proc44Repository = proc44Repository;
    }

    public void executeProc44(Integer input) {
        if (input == null) {
            LOGGER.error("Input ID is null");
            return;
        }

        try {
            String name = tableNameService.getNameById(input);
            if (name == null || name.isEmpty()) {
                LOGGER.error("Retrieved name is null or empty");
                return;
            } else {
                Table4Entity entity = new Table4Entity();
                entity.setId(input);
                entity.setName(name);
                entity.setCreatedAt(LocalDateTime.now());
                proc44Repository.save(entity);
                LOGGER.info("New record saved successfully");
            }
        } catch (Exception e) {
            LOGGER.error("Error executing proc44", e);
        }
    }
}