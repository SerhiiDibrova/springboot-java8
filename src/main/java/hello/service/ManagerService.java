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
            if (defaultManager != null) {
                return defaultManager.getId();
            } else {
                throw new RuntimeException("No default manager found");
            }
        }
        return managerId;
    }
}