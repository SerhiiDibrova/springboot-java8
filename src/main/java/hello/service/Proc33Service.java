

package hello.service;

import hello.entity.Table13;
import hello.repository.Table13Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class Proc33Service {
    @Autowired
    private Table13Repository table13Repository;

    public void execute(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        Table13 table13 = new Table13();
        table13.setName(func_3(input));
        table13.setCreatedAt(LocalDateTime.now());
        try {
            table13Repository.save(table13);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save record to table_13", e);
        }
    }

    private String func_3(Integer input) {
        // implement the logic for func_3 based on the input
        return "func_3 result for input " + input;
    }
}