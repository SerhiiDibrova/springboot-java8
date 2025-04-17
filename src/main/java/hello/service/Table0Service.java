

package hello.service;

import org.springframework.stereotype.Service;
import hello.repository.Table0Repository;
import hello.entity.Table0Entity;

@Service
public class Table0Service {

    private final Table0Repository table0Repository;

    public Table0Service(Table0Repository table0Repository) {
        this.table0Repository = table0Repository;
    }

    public void insertRecord(Table0Entity entity) {
        table0Repository.save(entity);
    }
}