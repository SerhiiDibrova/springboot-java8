package hello.service;

import hello.repository.ManagerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;
    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Long getDefaultManagerId(Long managerId) {
        if (managerId == null) {
            logger.info("managerId is null, querying for default manager ID.");
            try {
                Long defaultManagerId = managerRepository.findDefaultManagerIdByRole("system");
                if (defaultManagerId == null) {
                    logger.warn("No default manager found for role 'system'.");
                }
                return defaultManagerId;
            } catch (Exception e) {
                logger.error("Error retrieving default manager ID: {}", e.getMessage());
                throw new RuntimeException("Error retrieving default manager ID", e);
            }
        }
        logger.info("Using provided managerId: {}", managerId);
        return managerId;
    }
}