

package hello.service;

import hello.entity.Proc6Record;
import hello.repository.Proc6Repository;
import hello.service.Proc6Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Trigger6ServiceImpl implements Trigger6Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Trigger6ServiceImpl.class);

    private final Proc6Repository proc6Repository;
    private final Proc6Service proc6Service;

    @Autowired
    public Trigger6ServiceImpl(Proc6Repository proc6Repository, Proc6Service proc6Service) {
        this.proc6Repository = proc6Repository;
        this.proc6Service = proc6Service;
    }

    @Override
    public void executeTrigger(Proc6Record proc6Record) {
        if (proc6Record == null) {
            LOGGER.error("Input parameter proc6Record is null");
            return;
        }

        try {
            Proc6Record savedRecord = proc6Repository.save(proc6Record);
            Long id = savedRecord.getId();
            proc6Service.proc6(id);
        } catch (Exception e) {
            LOGGER.error("Error executing proc_6 stored procedure", e);
        }
    }
}