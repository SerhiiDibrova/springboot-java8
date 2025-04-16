

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Table14Service {

    private final Table14Repository table14Repository;
    private final GetNameById getNameById;

    @Autowired
    public Table14Service(Table14Repository table14Repository, GetNameById getNameById) {
        this.table14Repository = table14Repository;
        this.getNameById = getNameById;
    }

    public void createRecord(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        try {
            String name = getNameById.getName(id);
            Table14Record record = new Table14Record(name, LocalDateTime.now());
            table14Repository.save(record);
        } catch (Exception e) {
            throw new RuntimeException("Error creating record", e);
        }
    }
}