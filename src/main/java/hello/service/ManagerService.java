package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.ManagerRepository;
import java.util.Optional;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            try {
                Optional<Integer> defaultManagerId = managerRepository.findTopByDefaultAndRole(true, "system")
                        .map(manager -> manager.getId());
                return defaultManagerId.orElseThrow(() -> new RuntimeException("No default manager found"));
            } catch (Exception e) {
                throw new RuntimeException("Error retrieving default manager", e);
            }
        }
        return managerId;
    }
}