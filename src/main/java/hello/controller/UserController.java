package hello.controller;

import hello.model.UserCreateRequest;
import hello.model.UserResponse;
import hello.model.UserDTO;
import hello.service.UserService;
import hello.controller.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        UserDTO userDTO = service.getById(id);
        if(userDTO == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        UserResponse userResponse = service.createOrUpdateUser(userCreateRequest);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        service.deleteUserByEmail(email);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        UserResponse userResponse = service.getUserByEmail(email);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> listUsers(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "10") int limit) {
        List<UserResponse> users = service.listUsers(offset, limit);
        return ResponseEntity.ok(users);
    }
}