

package hello.service;

import hello.repository.Table6Repository;
import hello.model.Table6;
import hello.func.Func6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class Proc46ServiceImpl {

    private final Table6Repository table6Repository;
    private final Func6 func6;

    @Autowired
    public Proc46ServiceImpl(Table6Repository table6Repository, Func6 func6) {
        this.table6Repository = table6Repository;
        this.func6 = func6;
    }

    public void processInput(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer");
        }
        String stringValue = func6.apply();
        if (stringValue == null || stringValue.isEmpty()) {
            throw new IllegalStateException("Retrieved string value is null or empty");
        }
        try {
            Table6 table6 = new Table6(input, stringValue, LocalDateTime.now());
            table6Repository.save(table6);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred during database operation", e);
        }
    }
}