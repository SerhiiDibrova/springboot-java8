package hello.service;

import hello.repository.UserRepository;
import hello.record.AccountRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final UserRepository userRepository;

    @Autowired
    public AccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AccountRecord createAccount(AccountRecord accountRecord) {
        return userRepository.save(accountRecord);
    }

    public AccountRecord getAccount(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public void updateAccount(AccountRecord accountRecord) {
        userRepository.save(accountRecord);
    }

    public void deleteAccount(String id) {
        userRepository.deleteById(id);
    }
}