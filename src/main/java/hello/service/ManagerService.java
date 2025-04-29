package hello.service;

import org.springframework.stereotype.Service;
import hello.repository.ManagerRepository;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            var defaultManager = managerRepository.findTopByDefaultTrueAndRoleId("system");
            if (defaultManager != null) {
                managerId = defaultManager.getId();
            }
        }
        return managerId;
    }
}