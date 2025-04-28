package hello.controller;

import hello.model.UserCreateRequest;
import hello.model.UserResponse;
import hello.service.UserService;
import hello.service.ResponseService;
import hello.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final ResponseService responseService;

    @Autowired
    public UserController(UserService service, ResponseService responseService) {
        this.service = service;
        this.responseService = responseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        UserDTO userDTO = service.getById(id);
        if(userDTO == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        UserResponse userResponse = service.createUser(userCreateRequest);
        return ResponseEntity.ok(responseService.successResponse(userResponse));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        service.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        UserResponse userResponse = service.getByEmail(email);
        if (userResponse == null) {
            throw new ResourceNotFoundException("User not found with email: " + email);
        }
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> getAllUsers(@RequestParam(defaultValue = "0") int offset,
                                                           @RequestParam(defaultValue = "10") int limit) {
        List<UserResponse> users = service.getAllUsers(offset, limit);
        return ResponseEntity.ok(responseService.successResponse(users));
    }
}