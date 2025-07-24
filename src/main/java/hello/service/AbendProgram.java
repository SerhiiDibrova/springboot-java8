package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

@Service
public class AbendProgram {

    private static final Logger logger = LoggerFactory.getLogger(AbendProgram.class);
    public static int TIMING;
    public static int ABCODE;

    @Autowired
    private AbendProgramRepository abendProgramRepository;

    @Autowired
    private Cee3abdService cee3abdService;

    public AbendProgram() {
        TIMING = 0;
        ABCODE = 999;
    }

    public boolean abendProgram() {
        logger.info("ABENDING PROGRAM");
        try {
            if (cee3abdService != null) {
                cee3abdService.cee3abd();
                logger.info("Abnormal termination successful");
                return true;
            } else {
                logger.error("Cee3abdService is not properly injected");
                return false;
            }
        } catch (Exception e) {
            logger.error("Error during abnormal termination", e);
            return false;
        }
    }
}