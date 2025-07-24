package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;

@Service
public class AbendProgramService {

    private static final Logger logger = LoggerFactory.getLogger(AbendProgramService.class);

    private String abendMessage;
    private AtomicLong timingVariable;
    private int abnormalTerminationCode;
    private final ExecutorService executorService;

    @Autowired
    public AbendProgramService() {
        this.executorService = Executors.newSingleThreadExecutor();
    }

    @PostConstruct
    public void init() {
        abendMessage = "Abnormal program termination message";
        timingVariable = new AtomicLong(System.currentTimeMillis());
        abnormalTerminationCode = 1;
    }

    public void displayAbendMessage() {
        try {
            logger.error(abendMessage);
        } catch (Exception e) {
            logger.error("Error displaying abend message", e);
        }
    }

    public void initializeTimingVariable() {
        try {
            timingVariable.set(System.currentTimeMillis());
        } catch (Exception e) {
            logger.error("Error initializing timing variable", e);
        }
    }

    public void setAbnormalTerminationCode() {
        try {
            abnormalTerminationCode = 1;
        } catch (Exception e) {
            logger.error("Error setting abnormal termination code", e);
        }
    }

    public void callTerminationRoutine() {
        try {
            logger.error("Abnormal program termination");
            executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    logger.error("Error during termination routine", e);
                    Thread.currentThread().interrupt();
                }
            });
            executorService.shutdown();
            if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
            System.exit(abnormalTerminationCode);
        } catch (Exception e) {
            logger.error("Error during termination routine", e);
        }
    }
}