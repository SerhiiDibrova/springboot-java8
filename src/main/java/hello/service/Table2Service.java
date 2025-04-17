

package hello.service;

import hello.repository.Table2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Table2Service {

    @Autowired
    private Table2Repository table2Repository;

    public String getName(Integer id) {
        return Optional.ofNullable(table2Repository.findById(id))
                .map(Optional::orElseThrow)
                .map(Table2Entity::getName)
                .orElseThrow();
    }

    @Transactional
    public void executeProc2(Integer id) {
        Integer newId = table2Repository.insertRecord(id);
        table2Repository.executeProc2(newId);
    }

    public void insertRecord(Integer input) {
        String name = table2Repository.func_2(input);
        table2Repository.insertRecord(input, name, LocalDateTime.now());
    }
}