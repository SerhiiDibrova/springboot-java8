package hello.service;

import hello.repository.UserRepository;
import hello.exception.NoDefaultManagerFoundException;
import java.util.Optional;

public class ManagerService {
    private final UserRepository userRepository;

    public ManagerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer getDefaultManagerId(Integer managerId, Integer defaultManagerId) {
        if (managerId == null) {
            try {
                Optional<UserDB> user = userRepository.findDefaultManager();
                if (user.isPresent()) {
                    defaultManagerId = user.get().getId();
                    managerId = defaultManagerId;
                } else {
                    throw new NoDefaultManagerFoundException("No default manager found.");
                }
            } catch (Exception e) {
                throw new RuntimeException("Error retrieving default manager ID", e);
            }
        }
        return managerId;
    }
}