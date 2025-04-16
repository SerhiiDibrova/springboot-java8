

package hello.service;

import hello.entity.Proc33Entity;
import hello.repository.Proc33Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Proc33Service {

    private final Proc33Repository proc33Repository;

    @Autowired
    public Proc33Service(Proc33Repository proc33Repository) {
        this.proc33Repository = proc33Repository;
    }

    public void insertRecord(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }
        if (proc33Repository == null) {
            throw new NullPointerException("Proc33Repository instance is null");
        }
        String name = generateName(input);
        Proc33Entity proc33Entity = new Proc33Entity(name, LocalDateTime.now());
        try {
            proc33Repository.save(proc33Entity);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save Proc33Entity to database", e);
        }
    }

    private String generateName(int input) {
        return "Name_" + input;
    }
}