package hello.service;

import java.util.logging.Logger;
import java.util.regex.Pattern;

public class PinValidator {
    private static final Logger logger = Logger.getLogger(PinValidator.class.getName());

    public boolean isValidPin(String pin) {
        if (pin == null || pin.isEmpty()) {
            logger.severe("Pin is null or empty");
            return false;
        }
        if (pin.length() != 6) {
            logger.severe("Invalid pin length. Pin must be exactly 6 characters long");
            return false;
        }
        if (!Pattern.matches("\\d{6}", pin)) {
            logger.severe("Invalid pin. Pin must contain only digits");
            return false;
        }
        return true;
    }
}