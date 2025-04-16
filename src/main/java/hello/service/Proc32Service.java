

package hello.service;

import hello.entity.Proc32Entity;
import hello.repository.Proc32Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class Proc32Service {

    private final Proc32Repository proc32Repository;
    private final Supplier<String> nameGenerator;

    @Autowired
    public Proc32Service(Proc32Repository proc32Repository, Supplier<String> nameGenerator) {
        this.proc32Repository = proc32Repository;
        this.nameGenerator = nameGenerator;
    }

    public void proc32(Integer input) {
        Assert.notNull(input, "Input must not be null");
        String name = nameGenerator.get();
        Proc32Entity entity = new Proc32Entity(input, name, LocalDateTime.now());
        try {
            proc32Repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save entity", e);
        }
    }
}