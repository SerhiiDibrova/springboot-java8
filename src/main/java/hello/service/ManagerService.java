package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.ManagerRepository;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Long getDefaultManagerId(Long managerId) {
        if (managerId != null) {
            return managerId;
        }
        Long defaultManagerId = managerRepository.findDefaultManagerIdByRole("system");
        if (defaultManagerId == null) {
            throw new RuntimeException("No default manager found for the 'system' role.");
        }
        return defaultManagerId;
    }
}