package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import hello.service.AccountService;
import hello.dto.AccountRecord;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account")
    public ResponseEntity<AccountRecord> displayAccountRecord() {
        try {
            AccountRecord accountRecord = new AccountRecord();
            accountRecord = accountService.displayAccountRecord(accountRecord);
            return ResponseEntity.ok(accountRecord);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}