package hello.service;

import hello.repository.UserRepository;
import hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class ManagerService {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    public ManagerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            try {
                Optional<User> defaultManager = userRepository.findDefaultManager();
                if (defaultManager.isPresent()) {
                    return defaultManager.get().getId();
                } else {
                    logger.warn("No default manager found.");
                    return null;
                }
            } catch (Exception e) {
                logger.error("Error retrieving default manager: {}", e.getMessage());
                return null;
            }
        }
        return managerId;
    }
}