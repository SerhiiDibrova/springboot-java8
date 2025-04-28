package hello.service;

import hello.model.UserDTO;
import hello.repository.UserRepository;
import hello.entity.UserDB;
import hello.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getById(Integer id) {
        return userRepository.findById(id)
                .map(item -> new UserDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    public UserDTO createUser(UserDTO userDTO) {
        UserDB userDB = userRepository.findById(userDTO.getId())
                .map(existingUser -> {
                    existingUser.setName(userDTO.getName());
                    return userRepository.save(existingUser);
                })
                .orElseGet(() -> userRepository.save(new UserDB(userDTO.getId(), userDTO.getName())));
        return new UserDTO(userDB.getId(), userDB.getName());
    }

    public ResponseEntity<Map<String, String>> deleteUser(String email) {
        if (!userRepository.existsByEmail(email)) {
            return new ResponseEntity<>(createErrorResponse("User not found"), HttpStatus.NOT_FOUND);
        }
        userRepository.deleteByEmail(email);
        return ResponseEntity.ok(Map.of("message", "User deleted successfully"));
    }

    public UserDTO getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(item -> new UserDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new UserNotFoundException("User not found with email " + email));
    }

    public List<UserDTO> getUsers(int offset, int limit) {
        return userRepository.findAllUsersOrderedByEmail(offset, limit);
    }

    private Map<String, String> createErrorResponse(String message) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", message);
        return errorResponse;
    }
}