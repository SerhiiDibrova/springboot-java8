

package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@Service
public class Proc1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Proc1Service.class);

    private final Proc1Repository proc1Repository;

    @Autowired
    public Proc1Service(Proc1Repository proc1Repository) {
        this.proc1Repository = Objects.requireNonNull(proc1Repository, "proc1Repository must not be null");
    }

    public void executeProc1(@NotNull Integer input) {
        try {
            proc1Repository.executeProc1(input);
        } catch (Exception e) {
            LOGGER.error("Error executing proc1", e);
            throw new RuntimeException("Error executing proc1", e);
        }
    }

    public String getName(@NotNull Integer input) {
        try {
            return proc1Repository.getName(input);
        } catch (Exception e) {
            LOGGER.error("Error getting name", e);
            throw new RuntimeException("Error getting name", e);
        }
    }
}