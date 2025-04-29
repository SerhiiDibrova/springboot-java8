package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.ManagerRepository;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;
    private static final String SYSTEM_ROLE_ID = "system";
    private static final Integer DEFAULT_MANAGER_NOT_FOUND = -1;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            return managerRepository.findTopByIsDefaultTrueAndRoleId(SYSTEM_ROLE_ID)
                    .map(manager -> manager.getId())
                    .orElse(DEFAULT_MANAGER_NOT_FOUND);
        }
        return managerId;
    }
}