package hello.service;

import hello.ATM;

public class ATMService {
    public void runATM(int pin, double initialBalance) {
        ATM atm = new ATM(pin, initialBalance);
        atm.run();
    }
}