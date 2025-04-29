package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.UserRepository;
import hello.repository.RoleRepository;

@Service
public class ManagerService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public ManagerService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            try {
                Integer roleId = roleRepository.findRoleIdByName("system");
                if (roleId != null) {
                    Integer userId = userRepository.findDefaultUserIdByRoleIdAndDefaultValue(roleId, true);
                    if (userId != null) {
                        return userId;
                    }
                    return -1; // Specific value when no user is found
                }
            } catch (Exception e) {
                return -1; // Specific value for error handling
            }
            return -1; // Specific value when role ID is not found
        }
        return managerId;
    }
}