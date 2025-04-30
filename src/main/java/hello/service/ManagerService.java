package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;
import hello.repository.UserRepository;
import hello.entity.User;

@Service
public class ManagerService {

    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    private UserRepository userRepository;

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