

package hello.service;

import hello.repository.Table3Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
@Slf4j
public class Proc3Service {

    private final Table3Repository table3Repository;
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(Proc3Service.class);

    @Autowired
    public Proc3Service(Table3Repository table3Repository) {
        this.table3Repository = table3Repository;
    }

    public String getName(Integer input) {
        return dbo.func_3(input).toString();
    }

    @Transactional
    public void executeProc3(Integer id) {
        hello.entity.Table3 record = table3Repository.findById(id).orElseThrow();
        proc_3(record.getId());
    }
}