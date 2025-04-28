package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.UserRepository;
import java.util.Collections;

@Service
public class ManagerService {
    private final UserRepository userRepository;

    @Autowired
    public ManagerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            var user = userRepository.findTopByDefaultTrueAndRoleIdIn(Collections.singletonList("system"));
            if (user != null) {
                managerId = user.getId();
            }
        }
        return managerId;
    }
}