

package hello.service;

import hello.repository.Table7Repository;
import hello.service.proc.Proc7Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;

@Service
public class Trigger7Service {

    private final Table7Repository table7Repository;
    private final Proc7Service proc7Service;
    private final EntityManager entityManager;

    public Trigger7Service(Table7Repository table7Repository, Proc7Service proc7Service, EntityManager entityManager) {
        this.table7Repository = table7Repository;
        this.proc7Service = proc7Service;
        this.entityManager = entityManager;
    }

    @Transactional
    public void executeTrigger() {
        try {
            Object id = table7Repository.findLastInsertedId();
            if (id != null) {
                Object response = proc7Service.executeProc(id);
                // Perform additional processing or validation on the response
            } else {
                // Handle the case when id is null
            }
        } catch (Exception e) {
            // Handle exceptions thrown by the method
        }
    }
}