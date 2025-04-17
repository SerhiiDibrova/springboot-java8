

package hello.service;

import hello.repository.Table7Repository;
import hello.func.Func7;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Proc27Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc27Service.class);

    private final Table7Repository table7Repository;
    private final Func7 func7;

    public Proc27Service(Table7Repository table7Repository, Func7 func7) {
        this.table7Repository = table7Repository;
        this.func7 = func7;
    }

    public void createRecord(Integer input) {
        if (input == null) {
            LOGGER.error("Input parameter is null");
            return;
        }

        try {
            String name = func7.func_7(input);
            if (name == null || name.isEmpty()) {
                LOGGER.error("Retrieved string value is null or empty");
                return;
            }
            table7Repository.insert(name);
        } catch (Exception e) {
            LOGGER.error("Error creating record", e);
        }
    }
}