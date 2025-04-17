

package hello.service;

import hello.entity.Table19Entity;
import hello.repository.Table19Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Proc19Service {

    private final Table19Repository table19Repository;

    @Autowired
    public Proc19Service(Table19Repository table19Repository) {
        this.table19Repository = table19Repository;
    }

    @Transactional
    public void insertRecord(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        Table19Entity entity = new Table19Entity();
        entity.setName(func_9());
        entity.setId(input);
        entity.setCreatedAt(LocalDateTime.now());

        try {
            table19Repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Failed to insert record into table_19", e);
        }
    }

    private String func_9() {
        // Retrieve the name column value from a data source (e.g., database, API, etc.)
        // For demonstration purposes, assume a simple database query
        Optional<String> name = table19Repository.findName();

        return name.orElseThrow(() -> new RuntimeException("Failed to retrieve name column value"));
    }
}