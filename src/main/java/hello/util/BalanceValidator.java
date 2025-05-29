package hello.util;

public class BalanceValidator {
    public static boolean isValidBalance(String balance) {
        try {
            double amount = Double.parseDouble(balance);
            return amount >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}