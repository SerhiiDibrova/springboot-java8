package hello.service;

import hello.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ManagerService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    public ManagerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Integer getDefaultManagerId(Integer managerId) {
        try {
            if (managerId == null) {
                return userRepository.findTopByDefaultTrueAndRole_Role("system")
                        .map(user -> user.getId())
                        .orElse(null);
            }
            return managerId;
        } catch (DataAccessException e) {
            logger.error("Error accessing user data", e);
            return null;
        }
    }
}