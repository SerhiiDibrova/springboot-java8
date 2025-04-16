

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.repository.Table0Repository;
import hello.service.Proc0Service;

@Service
public class Trigger0Service {

    private final Table0Repository table0Repository;
    private final Proc0Service proc0Service;

    @Autowired
    public Trigger0Service(Table0Repository table0Repository, Proc0Service proc0Service) {
        if (table0Repository == null) {
            throw new NullPointerException("Table0Repository cannot be null");
        }
        if (proc0Service == null) {
            throw new NullPointerException("Proc0Service cannot be null");
        }
        this.table0Repository = table0Repository;
        this.proc0Service = proc0Service;
    }

    @Transactional(rollbackFor = Exception.class)
    public void executeTriggerLogicAfterInsert() {
        Long newlyInsertedRecordId = table0Repository.getNewlyInsertedRecordId();
        if (newlyInsertedRecordId != null) {
            try {
                proc0Service.executeProc0(newlyInsertedRecordId);
            } catch (Exception e) {
                throw new RuntimeException("Error executing proc_0 stored procedure", e);
            }
        }
    }
}