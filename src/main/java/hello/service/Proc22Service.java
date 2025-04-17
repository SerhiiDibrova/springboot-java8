

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hello.entity.Table2Entity;
import hello.repository.Table2Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class Proc22Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc22Service.class);

    @Autowired
    private Table2Repository table2Repository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${dbo.func_2}")
    private String func2;

    public void createRecord(Integer input) {
        Assert.notNull(input, "Input parameter cannot be null");
        Integer result = callFunc2(input);
        if (result != null) {
            Table2Entity entity = new Table2Entity(input, result);
            try {
                table2Repository.save(entity);
            } catch (Exception e) {
                LOGGER.error("Error saving entity to database", e);
            }
        } else {
            LOGGER.error("Result of function call is null");
        }
    }

    public Integer callFunc2(Integer input) {
        try {
            return restTemplate.getForObject(func2, Integer.class, input);
        } catch (Exception e) {
            LOGGER.error("Error calling function", e);
            return null;
        }
    }

    public void exampleUsage() {
        createRecord(1);
    }
}