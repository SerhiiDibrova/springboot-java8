

package hello.service;

import hello.repository.Table17Repository;
import hello.func.Func7;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Proc37Service {

    private final Table17Repository table17Repository;
    private final Func7 func7;
    private static final Logger logger = LoggerFactory.getLogger(Proc37Service.class);

    public Proc37Service(Table17Repository table17Repository, Func7 func7) {
        this.table17Repository = table17Repository;
        this.func7 = func7;
    }

    public Integer createRecord(Integer input) {
        if (input == null) {
            logger.error("Input parameter is null");
            return null;
        }
        try {
            String name = func7.func_7(input);
            if (name == null || name.isEmpty()) {
                logger.error("Retrieved string value is null or empty");
                return null;
            }
            return table17Repository.insert(name);
        } catch (Exception e) {
            logger.error("Error creating record", e);
            return null;
        }
    }
}