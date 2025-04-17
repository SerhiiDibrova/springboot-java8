

package hello.service;

import hello.repository.Table1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Table1Service {

    private final Table1Repository table1Repository;

    @Autowired
    public Table1Service(Table1Repository table1Repository) {
        this.table1Repository = table1Repository;
    }

    @Transactional
    public void insertRecord(Integer input) {
        String stringValue = func_1(input);
        table1Repository.insertRecord(stringValue);
    }

    private String func_1(Integer input) {
        return String.valueOf(input);
    }
}