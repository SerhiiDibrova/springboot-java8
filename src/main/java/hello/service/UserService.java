package hello.service;

import hello.model.UserDTO;
import hello.model.UserCreateRequest;
import hello.model.UserResponse;
import hello.model.UserListResponse;
import hello.entity.UserDB;
import hello.exception.UserNotFoundException;
import hello.repository.UserRepository;
import hello.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getById(Integer id) {
        return userRepository.findById(id)
                .map(item -> new UserDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    public UserResponse createUser(UserCreateRequest request) {
        UserDB userDB = new UserDB(request.getName(), request.getEmail());
        userRepository.save(userDB);
        userDB = userRepository.findByEmail(request.getEmail());
        return new UserResponse(userDB.getId(), userDB.getName(), userDB.getEmail());
    }

    public ResponseEntity<Map<String, String>> deleteUser(String email) {
        UserDB user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User not found with email " + email);
        }
        userRepository.delete(user);
        return ResponseService.success_response();
    }

    public UserDTO getUserByEmail(String email) {
        UserDB user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User not found with email " + email);
        }
        return new UserDTO(user.getId(), user.getName());
    }

    public List<UserDTO> listUsers(int offset, int limit) {
        return userRepository.findAll(offset, limit)
                .stream()
                .map(item -> new UserDTO(item.getId(), item.getName()))
                .toList();
    }
}