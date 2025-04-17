

package hello.service;

import hello.repository.Table9Repository;
import hello.model.Table9Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import external.func_9;

@Service
public class Table9Service {

    private final Table9Repository table9Repository;

    @Autowired
    public Table9Service(Table9Repository table9Repository) {
        this.table9Repository = table9Repository;
    }

    @Transactional
    public String getName(Integer id) {
        Table9Entity table9Entity = table9Repository.findById(id).orElse(null);
        if (table9Entity == null) {
            return null;
        }
        String name = func_9.func_9(table9Entity.getId());
        table9Repository.save(new Table9Entity(id, name));
        return name;
    }
}