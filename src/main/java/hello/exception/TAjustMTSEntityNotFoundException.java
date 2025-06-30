package hello.exception;

import java.util.logging.Logger;

public class TAjustMTS extends RuntimeException {
    private static final Logger logger = Logger.getLogger(TAjustMTS.class.getName());

    public TAjustMTS(String message) {
        super(message);
    }

    public static String HandleError(TAjustMTS exception) {
        logger.severe(exception.getMessage());
        return exception.getMessage();
    }

    public static void FormDestroy() {
        logger.info("Releasing resources and cleaning up form components");
    }
}