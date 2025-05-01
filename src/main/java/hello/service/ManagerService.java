package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;
import hello.repository.UserRepository;
import hello.model.User;

@Service
public class ManagerService implements ManagerServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    private UserRepository userRepository;

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