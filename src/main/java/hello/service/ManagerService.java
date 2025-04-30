package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ManagerService {

    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    private UserRepository userRepository;

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            try {
                Integer defaultManagerId = userRepository.findDefaultManager();
                if (defaultManagerId != null) {
                    logger.info("Retrieved default manager ID: {}", defaultManagerId);
                    return defaultManagerId;
                } else {
                    logger.warn("No default manager found.");
                    return null;
                }
            } catch (Exception e) {
                logger.error("Error retrieving default manager ID", e);
                return null;
            }
        }
        if (managerId < 0) {
            logger.warn("Invalid managerId provided: {}", managerId);
            return null;
        }
        return managerId;
    }
}