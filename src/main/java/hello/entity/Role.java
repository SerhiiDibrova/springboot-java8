package hello.service;

import hello.repository.UserRepository;
import hello.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private UserRepository userRepository;

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            Optional<User> user = userRepository.findDefaultManager();
            return user.map(User::getId).orElse(null);
        }
        return managerId;
    }
}