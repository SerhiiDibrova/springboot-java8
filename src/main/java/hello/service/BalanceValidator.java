package hello.service;

import java.io.PrintStream;

public class BalanceValidator {
    public boolean isValidBalance(String balance) {
        try {
            double balanceValue = Double.parseDouble(balance);
            if (balanceValue < 0) {
                System.err.println("Error: Balance cannot be negative.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid balance format.");
            return false;
        }
    }
}