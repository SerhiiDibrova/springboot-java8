

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Proc14Service {

    private final Table14Repository table14Repository;

    @Autowired
    public Proc14Service(Table14Repository table14Repository) {
        this.table14Repository = table14Repository;
    }

    public String getEntityName(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        try {
            return table14Repository.findById(id).orElseThrow();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving entity name", e);
        }
    }
}