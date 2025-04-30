package hello.service;

import hello.repository.UserRepository;
import hello.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

public class ManagerService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    public ManagerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            try {
                Optional<User> user = userRepository.findTopByDefaultTrueAndRole_Role("system");
                return user.map(User::getId).orElse(null);
            } catch (Exception e) {
                logger.error("Error retrieving default manager ID", e);
                return null;
            }
        }
        return managerId;
    }
}