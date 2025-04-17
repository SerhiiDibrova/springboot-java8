

package hello.service;

import hello.entity.Table18Entity;
import hello.repository.Table18Repository;
import hello.service.Table8Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Proc18Service {

    private final Table8Service table8Service;
    private final Table18Repository table18Repository;

    @Autowired
    public Proc18Service(Table8Service table8Service, Table18Repository table18Repository) {
        this.table8Service = table8Service;
        this.table18Repository = table18Repository;
    }

    public void insertRecord(Integer input) {
        String name = table8Service.getNameById(input);
        Table18Entity entity = new Table18Entity();
        entity.setId(input);
        entity.setName(name);
        entity.setDateTime(LocalDateTime.now());
        table18Repository.save(entity);
    }
}