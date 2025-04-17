

package hello.service;

import hello.entity.Table6;
import hello.repository.Table6Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class Proc46Service {

    private static final Logger logger = LoggerFactory.getLogger(Proc46Service.class);

    private final Table6Repository table6Repository;
    private final Func6 func6;

    @Autowired
    public Proc46Service(Table6Repository table6Repository, Func6 func6) {
        this.table6Repository = table6Repository;
        this.func6 = func6;
    }

    public void insertRecord(Integer input) {
        Assert.notNull(input, "Input cannot be null");
        try {
            Table6 table6 = new Table6();
            table6.setInput(input);
            table6Repository.save(table6);
        } catch (Exception e) {
            logger.error("Error inserting record into Table6", e);
            throw new RuntimeException("Error inserting record into Table6", e);
        }
    }

    public String callFunc6(Integer input) {
        Assert.notNull(input, "Input cannot be null");
        try {
            Optional<String> result = func6.call(input);
            return result.orElse("No result from func_6");
        } catch (Exception e) {
            logger.error("Error calling func_6", e);
            throw new RuntimeException("Error calling func_6", e);
        }
    }
}