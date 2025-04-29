package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.UserRepository;
import hello.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ManagerService {

    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    private UserRepository userRepository;

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            try {
                List<User> users = userRepository.findTopByDefaultAndRoleId("system", true);
                if (!users.isEmpty() && users.get(0) != null) {
                    return users.get(0).getId();
                }
            } catch (Exception e) {
                logger.error("Error retrieving default manager ID", e);
            }
            return null;
        }
        return managerId;
    }
}