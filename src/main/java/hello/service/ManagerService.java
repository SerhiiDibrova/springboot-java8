package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.UserRepository;
import hello.dto.ManagerIdDTO;

@Service
public class ManagerService {

    @Autowired
    private UserRepository userRepository;

    public ManagerIdDTO getDefaultManagerId(Long managerId) {
        if (managerId == null) {
            ManagerIdDTO defaultManager = userRepository.findDefaultManagerId();
            if (defaultManager == null) {
                throw new RuntimeException("No default manager found");
            }
            return defaultManager;
        }
        return new ManagerIdDTO(managerId);
    }
}