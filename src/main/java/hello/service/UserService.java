package hello.service;

import hello.model.UserDTO;
import hello.model.UserCreateRequest;
import hello.model.UserResponse;
import hello.model.UserListResponse;
import hello.entity.UserDB;
import hello.repository.UserRepository;
import hello.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponse createUser(UserCreateRequest userCreateRequest) {
        UserDB userDB = userRepository.findByEmail(userCreateRequest.getEmail())
                .orElse(new UserDB());
        userDB.setName(userCreateRequest.getName());
        userDB.setEmail(userCreateRequest.getEmail());
        userRepository.save(userDB);
        return getUserByEmail(userCreateRequest.getEmail());
    }

    public ResponseEntity<?> deleteUser(String email) {
        if (!userRepository.existsByEmail(email)) {
            return ResponseUtil.notFound("User not found with email " + email);
        }
        userRepository.deleteByEmail(email);
        return ResponseUtil.success("User deleted successfully");
    }

    public UserResponse getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(item -> new UserResponse(item.getId(), item.getName(), item.getEmail()))
                .orElse(null);
    }

    public List<UserDB> getUsers() {
        return userRepository.findAllByOrderByEmail();
    }
}