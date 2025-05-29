package hello.util;

public class PinValidator {
    public static boolean isValidPin(String pin) {
        if (pin.length() != 6) {
            return false;
        }
        for (char c : pin.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}