

package hello.service;

import hello.entity.Table9Entity;
import hello.event.InsertEvent;
import hello.repository.Table9Repository;
import hello.service.Proc9Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class Trigger9Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Trigger9Service.class);

    private final Table9Repository table9Repository;
    private final Proc9Service proc9Service;

    @Autowired
    public Trigger9Service(Table9Repository table9Repository, Proc9Service proc9Service) {
        this.table9Repository = table9Repository;
        this.proc9Service = proc9Service;
    }

    @EventListener
    public void handleInsertEvent(InsertEvent event) {
        if (event.getEntity() instanceof Table9Entity) {
            Table9Entity entity = (Table9Entity) event.getEntity();
            if (entity != null) {
                Long id = entity.getId();
                if (id != null) {
                    try {
                        proc9Service.proc9(id);
                    } catch (Exception e) {
                        LOGGER.error("Error executing proc9 service", e);
                    }
                } else {
                    LOGGER.error("Id is null for entity {}", entity);
                }
            } else {
                LOGGER.error("Entity is null");
            }
        }
    }
}