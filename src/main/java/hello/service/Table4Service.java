

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.entity.Table4Entity;
import hello.repository.Table4Repository;

@Service
public class Table4Service {

    @Autowired
    private Table4Repository table4Repository;

    public String getName(Integer id) {
        if (id == null) {
            return null;
        }
        Table4Entity table4Entity = table4Repository.findById(id).orElse(null);
        return table4Entity != null ? table4Entity.getName() : null;
    }

    public void insertRecord(Integer inputParam) {
        try {
            String value = func_4(inputParam);
            Table4Entity table4Entity = new Table4Entity();
            table4Entity.setName(value);
            table4Repository.save(table4Entity);
        } catch (Exception e) {
            // handle exception
        }
    }

    private String func_4(Integer inputParam) {
        // implementation of func_4
        return "value";
    }
}