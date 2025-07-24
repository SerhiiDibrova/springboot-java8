package hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbendProgram {

    private static final Logger logger = LoggerFactory.getLogger(AbendProgram.class);
    private static final int ABEND_CODE = 9999;
    private long timingVariable;
    private int abendCode;

    public void abendProgram() {
        displayAbendMessage();
        initializeTimingVariable();
        setAbendCode(ABEND_CODE);
        try {
            cee3abd(abendCode);
        } catch (Exception e) {
            logger.error("Error occurred during cee3abd method", e);
        }
    }

    private void displayAbendMessage() {
        System.out.println("Abend message");
    }

    private void initializeTimingVariable() {
        timingVariable = System.currentTimeMillis();
    }

    private void setAbendCode(int abendCode) {
        this.abendCode = abendCode;
        logger.info("Abend code set to: {}", abendCode);
    }

    private void cee3abd(int abendCode) {
        logger.error("Error with abend code: {}", abendCode);
        performCleanupActions();
        terminateProgramAbnormally();
    }

    private void performCleanupActions() {
        logger.info("Performing cleanup actions");
        // Add actual cleanup actions here, e.g., closing files, releasing resources, etc.
    }

    private void terminateProgramAbnormally() {
        logger.info("Terminating program abnormally with abend code: {}", abendCode);
        System.exit(abendCode);
    }
}