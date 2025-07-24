package hello.service;

import org.springframework.stereotype.Service;
import hello.dto.AccountRecord;

@Service
public class AccountService {

    public void displayAccountRecord(AccountRecord accountRecord) {
        if (accountRecord != null) {
            try {
                System.out.println("Account Number: " + accountRecord.getAccountNumber());
                System.out.println("Account Holder: " + accountRecord.getAccountHolder());
                System.out.println("Account Type: " + accountRecord.getAccountType());
                System.out.println("Account Balance: " + accountRecord.getAccountBalance());
            } catch (Exception e) {
                System.out.println("An error occurred while displaying account record: " + e.getMessage());
            }
        } else {
            System.out.println("Account record is null");
        }
    }
}