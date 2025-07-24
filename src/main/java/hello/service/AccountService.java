package hello.service;

import hello.model.Account;
import hello.repository.AccountRepository;

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Account account) {
        Account existingAccount = accountRepository.findById(account.getId()).orElseThrow();
        existingAccount.setName(account.getName());
        existingAccount.setEmail(account.getEmail());
        return accountRepository.save(existingAccount);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}