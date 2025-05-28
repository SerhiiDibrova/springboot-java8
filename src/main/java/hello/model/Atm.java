package hello.model;

public class Atm {
    private int pin;
    private double balance;

    public Atm(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public void executeAtmFunctionality() {
        System.out.println("ATM is functioning");
        System.out.println("Current balance: " + balance);
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}