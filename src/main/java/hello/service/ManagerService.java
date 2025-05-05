package hello.service;

import hello.repository.ManagerRepository;
import hello.exception.ManagerNotFoundException;
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

    public Integer getDefaultManagerId(Integer managerId, Integer defaultManagerId) {
        if (managerId == null) {
            try {
                defaultManagerId = managerRepository.findDefaultManagerId();
                if (defaultManagerId == null) {
                    throw new ManagerNotFoundException("No default manager found.");
                }
                managerId = defaultManagerId;
            } catch (Exception e) {
                logger.error("Error retrieving default manager ID", e);
                throw new RuntimeException("Database connection issue or unexpected error.", e);
            }
        }
        return managerId;
    }
}