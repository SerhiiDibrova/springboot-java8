package hello.service;

import hello.repository.UserRepository;
import hello.model.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetDefaultManagerIdService {

    private final UserRepository userRepository;

    @Autowired
    public GetDefaultManagerIdService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Integer getDefaultManagerId(Integer managerId) {
        if (managerId == null) {
            Optional<UserDB> user = userRepository.findDefaultManager();
            if (user.isPresent()) {
                managerId = user.get().getId();
            }
        }
        return managerId;
    }
}