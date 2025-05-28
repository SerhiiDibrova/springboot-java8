package hello.controller;

import hello.entity.AtmEntity;
import hello.entity.AtmResponse;
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

    public AtmResponse createAndRunAtm(String pin, String balance) {
        if (pin == null || pin.isEmpty() || balance == null || balance.isEmpty()) {
            return new AtmResponse("Error: PIN and balance cannot be null or empty.");
        }
        if (!pinValidator.isValidPin(pin)) {
            return new AtmResponse("Error: Invalid PIN. Please enter a 4-digit PIN.");
        }
        try {
            double balanceValue = Double.parseDouble(balance);
            if (!balanceValidator.isValidBalance(balanceValue)) {
                return new AtmResponse("Error: Invalid balance. Please enter a valid balance.");
            }
            AtmEntity atmEntity = new AtmEntity(pin, balanceValue);
            String result = atmService.run(atmEntity);
            return new AtmResponse(result);
        } catch (NumberFormatException e) {
            return new AtmResponse("Error: Invalid balance. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        PinValidator pinValidator = new PinValidator();
        BalanceValidator balanceValidator = new BalanceValidator();
        AtmService atmService = new AtmService();
        AtmController atmController = new AtmController(pinValidator, balanceValidator, atmService);
        if (args.length == 2) {
            String pin = args[0];
            String balance = args[1];
            AtmResponse response = atmController.createAndRunAtm(pin, balance);
            System.out.println(response.getResult());
        } else {
            System.out.println("Usage: java -jar atm.jar <pin> <balance>");
        }
    }
}