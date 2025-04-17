

package hello.service;

import hello.repository.Table4Repository;
import hello.service.Proc4Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Trigger4Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Trigger4Service.class);

    private final Table4Repository table4Repository;
    private final Proc4Service proc4Service;

    @Autowired
    public Trigger4Service(Table4Repository table4Repository, Proc4Service proc4Service) {
        this.table4Repository = table4Repository;
        this.proc4Service = proc4Service;
    }

    @Transactional
    public Object executeTrigger(Integer id) {
        if (id == null) {
            LOGGER.error("Id cannot be null");
            throw new IllegalArgumentException("Id cannot be null");
        }

        Object record = table4Repository.findById(id).orElse(null);
        if (record == null) {
            LOGGER.error("Record not found for id: {}", id);
            throw new RuntimeException("Record not found for id: " + id);
        }

        try {
            Object result = proc4Service.executeProc4(record);
            return result;
        } catch (Exception e) {
            LOGGER.error("Error executing stored procedure", e);
            throw new RuntimeException("Error executing stored procedure", e);
        }
    }
}