package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import hello.repository.UserRepository;
import hello.model.User;

@Service
public class ManagerService {

    private final UserRepository userRepository;

    @Autowired
    public ManagerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            Optional<User> user = userRepository.findTopByDefaultTrueAndRole_Role("system");
            return user.map(User::getId).orElse(null);
        }
        return managerId;
    }
}