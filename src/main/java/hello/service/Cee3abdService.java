package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

@Service
public class Cee3abdService {

    private static final Logger LOGGER = Logger.getLogger(Cee3abdService.class.getName());

    private final EntityManager entityManager;

    @Autowired
    public Cee3abdService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void logError(String message) {
        LOGGER.severe(message);
    }

    @Transactional
    public void cleanupResources() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                entityManager.clear();
            } catch (Exception e) {
                logError("Error during cleanup: " + e.getMessage());
            } finally {
                executor.shutdown();
            }
        });
    }

    public void terminateProgram() {
        try {
            System.exit(0);
        } catch (Exception e) {
            logError("Error during termination: " + e.getMessage());
        }
    }
}