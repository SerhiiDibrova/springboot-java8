package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.UserRepository;
import hello.model.User;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private UserRepository userRepository;

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            Optional<User> defaultManager = userRepository.findTopByDefaultAndRole("system");
            return defaultManager.map(User::getId).orElseThrow(() -> new CustomException("No default manager found"));
        }
        return managerId;
    }
}