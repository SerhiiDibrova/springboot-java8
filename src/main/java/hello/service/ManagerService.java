package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.UserRepository;

@Service
public class ManagerService {

    private final UserRepository userRepository;

    @Autowired
    public ManagerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            Integer defaultManagerId = userRepository.findDefaultManager();
            if (defaultManagerId == null) {
                throw new IllegalStateException("No default manager found");
            }
            return defaultManagerId;
        }
        if (managerId <= 0) {
            throw new IllegalArgumentException("Manager ID must be positive");
        }
        return managerId;
    }
}