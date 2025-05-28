package hello.controller;

import hello.entity.AtmEntity;
import hello.service.AtmService;
import hello.validator.BalanceValidator;
import hello.validator.PinValidator;

public class AtmController {
    private PinValidator pinValidator;
    private BalanceValidator balanceValidator;
    private AtmService atmService;

    public AtmController(PinValidator pinValidator, BalanceValidator balanceValidator, AtmService atmService) {
        this.pinValidator = pinValidator;
        this.balanceValidator = balanceValidator;
        this.atmService = atmService;
    }

    public void createAndRunAtm(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar atm.jar <pin> <balance>");
            return;
        }
        String pin = args[0];
        String balance = args[1];
        if (pin == null || pin.isEmpty() || balance == null || balance.isEmpty()) {
            System.out.println("Error: PIN and balance cannot be null or empty.");
            return;
        }
        if (!pinValidator.isValidPin(pin)) {
            System.out.println("Error: Invalid PIN. Please enter a 4-digit PIN.");
            return;
        }
        if (!balanceValidator.isValidBalance(balance)) {
            System.out.println("Error: Invalid balance. Please enter a valid balance.");
            return;
        }
        AtmEntity atmEntity = new AtmEntity(pin, balance);
        atmService.run(atmEntity);
    }

    public static void main(String[] args) {
        PinValidator pinValidator = new PinValidator();
        BalanceValidator balanceValidator = new BalanceValidator();
        AtmService atmService = new AtmService();
        AtmController atmController = new AtmController(pinValidator, balanceValidator, atmService);
        atmController.createAndRunAtm(args);
    }
}