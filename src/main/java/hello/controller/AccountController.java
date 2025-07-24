package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import hello.service.AccountService;
import hello.model.Account;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<Account> displayAccountRecord(@PathVariable Long accountId) {
        Account account = accountService.displayAccountRecord(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}