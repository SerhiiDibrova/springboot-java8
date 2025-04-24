package hello.service;

import model.User;
import repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository repo = new UserRepository();

    public User getUser(int id) {
        return repo.getById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
