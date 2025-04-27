package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.UserRepository;
import hello.model.User;

@Service
public class ManagerService {

    @Autowired
    private UserRepository userRepository;

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            User defaultManager = userRepository.findTopByDefaultAndRole("system");
            return defaultManager != null ? defaultManager.getId() : null;
        }
        return managerId;
    }
}