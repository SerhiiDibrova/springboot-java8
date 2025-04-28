package hello.controller;

import hello.model.UserDTO;
import hello.model.UserCreateRequest;
import hello.model.UserResponse;
import hello.model.UserListResponse;
import hello.service.UserService;
import hello.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<UserResponse> createOrUpdateUser(@RequestBody UserCreateRequest userCreateRequest) {
        UserResponse userResponse = service.createOrUpdateUser(userCreateRequest);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        UserResponse userResponse = service.getByEmail(email);
        if(userResponse == null) {
            throw new UserNotFoundException("User not found with email: " + email);
        }
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUserByEmail(@PathVariable String email) {
        service.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/")
    public ResponseEntity<UserListResponse> listUsers(@RequestParam Optional<Integer> offset, @RequestParam Optional<Integer> limit) {
        int offsetValue = offset.orElse(0);
        int limitValue = limit.orElse(10);
        UserListResponse userListResponse = service.listUsers(offsetValue, limitValue);
        return ResponseEntity.ok(userListResponse);
    }
}