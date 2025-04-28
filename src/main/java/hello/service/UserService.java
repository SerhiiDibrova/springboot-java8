package hello.service;

import hello.model.UserDTO;
import hello.model.UserCreateRequest;
import hello.model.UserResponse;
import hello.repository.UserRepository;
import hello.controller.ResponseUtil;
import hello.entity.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserCreateRequest request) {
        UserDB user = new UserDB(request.getName(), request.getEmail());
        userRepository.save(user);
        return ResponseUtil.success_response(mapToUserResponse(userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found after upsert"))));
    }

    public ResponseEntity<Void> deleteUser(String email) {
        if (!userRepository.existsByEmail(email)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        userRepository.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    public UserResponse getUserByEmail(String email) {
        UserDB user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with email " + email));
        return mapToUserResponse(user);
    }

    public List<UserResponse> listUsers(int offset, int limit) {
        return userRepository.findAll(offset, limit).stream()
                .map(this::mapToUserResponse)
                .toList();
    }

    private UserResponse mapToUserResponse(UserDB user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}