package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import hello.service.ATMService;
import hello.validator.PinValidator;
import hello.validator.BalanceValidator;

@RestController
@RequestMapping("/api")
@Validated
public class MainController {

    private final ATMService atmService;

    public MainController(ATMService atmService) {
        this.atmService = atmService;
    }

    @PostMapping("/runATM")
    public ResponseEntity<?> runATM(@Valid @RequestBody ATMRequest atmRequest) {
        if (!PinValidator.isValid(atmRequest.getPin())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid PIN: PIN must be a 4-digit number.");
        }
        if (!BalanceValidator.isValid(atmRequest.getInitialBalance())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Balance: Balance must be a positive number.");
        }
        atmService.createAndRunATM(atmRequest.getPin(), atmRequest.getInitialBalance());
        return ResponseEntity.ok("ATM simulation started successfully");
    }

    public static class ATMRequest {
        @NotNull
        @Pattern(regexp = "\\d{4}")
        private String pin;

        @NotNull
        @Positive
        private Double initialBalance;

        public String getPin() {
            return pin;
        }

        public void setPin(String pin) {
            this.pin = pin;
        }

        public Double getInitialBalance() {
            return initialBalance;
        }

        public void setInitialBalance(Double initialBalance) {
            this.initialBalance = initialBalance;
        }
    }
}