package hello.service;

import hello.model.UserDTO;
import hello.model.UserCreateRequest;
import hello.model.UserResponse;
import hello.model.UserListResponse;
import hello.entity.UserDB;
import hello.repository.UserRepository;
import hello.service.ResponseService;
import hello.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ResponseService responseService;

    @Autowired
    public UserService(UserRepository userRepository, ResponseService responseService) {
        this.userRepository = userRepository;
        this.responseService = responseService;
    }

    @Transactional
    public UserResponse createUser(UserCreateRequest request) {
        UserDB userDB = new UserDB(request.getName(), request.getEmail());
        userRepository.save(userDB);
        return new UserResponse(userDB.getId(), userDB.getName(), userDB.getEmail());
    }

    public void deleteUser(String email) {
        UserDB userDB = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email " + email));
        userRepository.delete(userDB);
    }

    public UserDTO getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(item -> new UserDTO(item.getId(), item.getName()))
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email " + email));
    }

    public UserListResponse listUsers(int offset, int limit) {
        List<UserDTO> users = userRepository.findAll(offset, limit)
                .stream()
                .map(item -> new UserDTO(item.getId(), item.getName()))
                .toList();
        return responseService.successResponse(users);
    }
}