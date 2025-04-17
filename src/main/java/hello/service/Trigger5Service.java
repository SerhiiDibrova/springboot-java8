

package hello.service;

import hello.repository.Table5Repository;
import hello.service.Proc5Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Trigger5Service {

    private final Table5Repository table5Repository;
    private final Proc5Service proc5Service;

    public Trigger5Service(Table5Repository table5Repository, Proc5Service proc5Service) {
        this.table5Repository = table5Repository;
        this.proc5Service = proc5Service;
    }

    @Transactional
    public void execute() {
        Long id = table5Repository.findLastInsertedId();
        if (id != null) {
            try {
                proc5Service.execute(id);
            } catch (Exception e) {
                // handle exception
            }
        } else {
            // handle case when id is null
        }
    }
}