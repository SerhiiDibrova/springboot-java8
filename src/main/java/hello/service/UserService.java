package hello.service;

import hello.model.UserDTO;
import hello.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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

    public UserDTO getUser(Integer id) {
        return getById(id);
    }

    public String getUserAsString(Integer id) {
        UserDTO user = getUser(id);
        return "User ID: " + user.getId() + ", Name: " + user.getName();
    }
}