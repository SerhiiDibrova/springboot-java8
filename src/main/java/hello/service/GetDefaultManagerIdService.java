package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.UserRepository;
import hello.repository.RoleRepository;

@Service
public class GetDefaultManagerIdService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            Integer defaultManagerId = userRepository.findDefaultManagerId();
            if (defaultManagerId == null) {
                throw new IllegalArgumentException("No default manager ID found.");
            }
            return defaultManagerId;
        }
        return managerId;
    }
}