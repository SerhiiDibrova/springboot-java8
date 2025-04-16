

package hello.service;

import hello.entity.Proc45Entity;
import hello.repository.Proc45Repository;
import java.time.LocalDateTime;
import java.util.Objects;

public class Proc45Service {

    private final Proc45Repository proc45Repository;

    public Proc45Service(Proc45Repository proc45Repository) {
        this.proc45Repository = Objects.requireNonNull(proc45Repository, "proc45Repository must not be null");
    }

    public void insertRecord(int inputParam) {
        if (inputParam <= 0) {
            throw new IllegalArgumentException("inputParam must be greater than 0");
        }
        String name = func_5(inputParam);
        Proc45Entity entity = new Proc45Entity(inputParam, name, LocalDateTime.now());
        try {
            proc45Repository.insert(entity);
        } catch (Exception e) {
            throw new RuntimeException("Failed to insert record into database", e);
        }
    }

    private String func_5(int inputParam) {
        // implementation of func_5 function
        return "name";
    }
}