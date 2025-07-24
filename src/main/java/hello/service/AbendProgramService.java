package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AbendProgramService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbendProgramService.class);

    private final CBACT02C9910DisplayIOStatusService displayIOStatusService;

    @Autowired
    public AbendProgramService(CBACT02C9910DisplayIOStatusService displayIOStatusService) {
        this.displayIOStatusService = displayIOStatusService;
    }

    public void abendProgram(String ioStatus, String ioStat1, String ioStat2) {
        try {
            if (!isNumeric(ioStatus) || ioStat1.equals("9")) {
                displayIOStatusService.displayIOStatus(ioStatus, ioStat1, ioStat2);
                LOGGER.error("Abend message");
                long timingVariable = System.currentTimeMillis();
                int abnormalTerminationCode = 9999;
                throw new AbnormalTerminationException();
            } else {
                displayIOStatusService.displayIOStatus(ioStatus, ioStat1, ioStat2);
                LOGGER.error("Abend message");
                long timingVariable = System.currentTimeMillis();
                int abnormalTerminationCode = 9999;
                throw new AbnormalTerminationException();
            }
        } catch (AbnormalTerminationException e) {
            LOGGER.error("Abnormal termination occurred", e);
            throw e;
        } catch (Exception e) {
            LOGGER.error("An error occurred during abnormal termination", e);
            throw new AbnormalTerminationException();
        }
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

class AbnormalTerminationException extends RuntimeException {
    public AbnormalTerminationException() {
        super("Abnormal termination occurred");
    }

    public AbnormalTerminationException(String message) {
        super(message);
    }

    public AbnormalTerminationException(Throwable cause) {
        super(cause);
    }

    public AbnormalTerminationException(String message, Throwable cause) {
        super(message, cause);
    }
}