package hello.service;

import org.springframework.stereotype.Service;
import hello.model.AccountRecord;

@Service
public class AccountRecordDisplayService {

    public void displayAccountRecord(AccountRecord accountRecord) {
        System.out.println("Account Record Information:");
        System.out.println("Account Number: " + accountRecord.getAccountNumber());
        System.out.println("Account Holder: " + accountRecord.getAccountHolder());
        System.out.println("Account Balance: " + accountRecord.getAccountBalance());
        System.out.println("Account Type: " + accountRecord.getAccountType());
    }
}