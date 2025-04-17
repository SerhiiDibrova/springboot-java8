

package hello.service;

import hello.repository.Table3Repository;
import hello.service.Proc3Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Trigger3Service {

    private final Table3Repository table3Repository;
    private final Proc3Service proc3Service;
    private final Logger logger = LoggerFactory.getLogger(Trigger3Service.class);

    public Trigger3Service(Table3Repository table3Repository, Proc3Service proc3Service) {
        this.table3Repository = table3Repository;
        this.proc3Service = proc3Service;
    }

    @Transactional
    public void executeTrigger3() {
        var id = table3Repository.findTopByOrderByIdDesc().getId();
        proc3Service.executeProc3(id);
    }
}