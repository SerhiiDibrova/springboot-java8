package hello.service;

import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    private UserRepository userRepository;

    public Integer getDefaultManagerId(Integer managerId, Integer defaultManagerId) {
        if (managerId == null) {
            try {
                Integer foundManagerId = userRepository.findDefaultManager();
                if (foundManagerId != null) {
                    managerId = foundManagerId;
                } else {
                    managerId = defaultManagerId;
                }
            } catch (Exception e) {
                throw new RuntimeException("Error retrieving default manager ID", e);
            }
        }
        return managerId;
    }
}