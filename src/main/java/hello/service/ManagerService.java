package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.UserRepository;
import hello.entity.User;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ManagerService {

    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    private UserRepository userRepository;

    public Long getDefaultManagerId(Long managerId) {
        if (managerId == null) {
            try {
                Optional<User> defaultManager = userRepository.findDefaultManager();
                return defaultManager.map(User::getId).orElseThrow(() -> new RuntimeException("No default manager found"));
            } catch (Exception e) {
                logger.error("Error retrieving default manager", e);
                throw new RuntimeException("Error retrieving default manager", e);
            }
        }
        return managerId;
    }
}