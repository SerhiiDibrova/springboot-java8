

package hello.service;

import hello.repository.Table0Repository;
import hello.util.Func0Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Service
public class Proc40Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc40Service.class);

    private final Table0Repository table0Repository;
    private final Func0Util func0Util;

    @Autowired
    public Proc40Service(Table0Repository table0Repository, Func0Util func0Util) {
        this.table0Repository = table0Repository;
        this.func0Util = func0Util;
    }

    public void createRecord(Integer input) {
        Assert.notNull(input, "Input parameter cannot be null");
        try {
            String name = func0Util.getStringValue(input);
            Table0 table0 = new Table0();
            table0.setId(input);
            table0.setName(name);
            table0.setCreatedAt(LocalDateTime.now());
            table0Repository.save(table0);
            LOGGER.info("Record created successfully");
        } catch (Exception e) {
            LOGGER.error("Error creating record", e);
            throw new RuntimeException("Error creating record", e);
        }
    }
}