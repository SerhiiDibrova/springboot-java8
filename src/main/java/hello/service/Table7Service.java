

package hello.service;

import hello.repository.Table7Repository;
import hello.func.Func7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Rollback;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class Table7Service {

    @Autowired
    private Table7Repository table7Repository;

    @Autowired
    private Func7 func7;

    @Transactional(rollbackFor = Exception.class)
    public void createRecord(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        if (table7Repository == null) {
            throw new IllegalStateException("Table7Repository is not initialized");
        }
        if (func7 == null) {
            throw new IllegalStateException("Func7 is not initialized");
        }
        String name = func7.func_7(input);
        table7Repository.insertRecord(name);
    }

    @ExceptionHandler(Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public void handleException(Exception e) {
        throw new RuntimeException("An error occurred while creating a record", e);
    }
}