package hello.service;

import hello.repository.UserRepository;
import hello.exception.NoDefaultManagerException;
import hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ManagerService {

    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    private UserRepository userRepository;

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            Optional<User> defaultManager = userRepository.findDefaultManager();
            if (defaultManager.isPresent()) {
                return defaultManager.get().getId();
            } else {
                logger.error("No default manager found.");
                throw new NoDefaultManagerException("No default manager exists.");
            }
        }
        return managerId;
    }
}