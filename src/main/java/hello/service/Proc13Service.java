

package hello.service;

import hello.entity.Table3Entity;
import hello.repository.Table3Repository;
import hello.service.func.Func3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Service
public class Proc13Service {

    @Autowired
    @NotNull
    private Func3Service func3Service;

    @Autowired
    @NotNull
    private Table3Repository table3Repository;

    @Transactional(rollbackFor = Exception.class)
    public void insertRecord(@NotNull Integer input) {
        if (input == null) {
            throw new NullPointerException("Input parameter cannot be null");
        }
        String name = func3Service.getName(input);
        Table3Entity entity = new Table3Entity();
        entity.setInput(input);
        entity.setName(name);
        if (entity == null) {
            throw new NullPointerException("Table3Entity object cannot be null");
        }
        try {
            table3Repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting record into table_13", e);
        }
    }
}