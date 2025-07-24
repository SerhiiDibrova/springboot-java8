package hello.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import hello.service.AccountRecordDisplayService;
import hello.model.AccountRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AccountRecordController {

    private final AccountRecordDisplayService accountRecordDisplayService;
    private static final Logger logger = LoggerFactory.getLogger(AccountRecordController.class);

    @Autowired
    public AccountRecordController(AccountRecordDisplayService accountRecordDisplayService) {
        this.accountRecordDisplayService = accountRecordDisplayService;
    }

    @GetMapping("/account-record")
    public void displayAccountRecord() {
        try {
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setAccountNumber("1234567890");
            accountRecord.setAccountHolderName("John Doe");
            accountRecord.setAccountBalance(1000.0);
            accountRecordDisplayService.displayAccountRecord(accountRecord);
        } catch (Exception e) {
            logger.error("Error displaying account record", e);
        }
    }
}