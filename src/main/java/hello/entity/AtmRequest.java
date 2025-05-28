package hello.entity;

public class AtmRequest {
    private int pin;
    private double balance;

    public AtmRequest() {}

    public AtmRequest(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
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