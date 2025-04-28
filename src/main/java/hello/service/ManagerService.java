package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import hello.repository.UserRepository;
import hello.model.User;

@Service
public class ManagerService {
    @Autowired
    private UserRepository userRepository;

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            Optional<User> user = userRepository.findFirstByDefaultAndRole_Role(true, "system");
            return user.map(User::getId).orElse(null);
        }
        return managerId;
    }
}