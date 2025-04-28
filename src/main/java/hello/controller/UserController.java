package hello.controller;

import hello.model.UserDTO;
import hello.model.UserResponse;
import hello.model.UserListResponse;
import hello.model.UserCreateRequest;
import hello.service.UserService;
import hello.util.ResponseUtil;
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
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateRequest request) {
        UserResponse userResponse = service.createUser(request);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        UserResponse userResponse = service.getByEmail(email);
        if(userResponse == null) { throw new UserNotFoundException(); }
        return ResponseUtil.success_response(userResponse);
    }

    @GetMapping("/")
    public ResponseEntity<UserListResponse> listUsers(@RequestParam(defaultValue = "0") int offset, 
                                                      @RequestParam(defaultValue = "10") int limit) {
        List<UserDTO> users = service.listUsers(offset, limit);
        UserListResponse response = new UserListResponse(users);
        return ResponseUtil.success_response(response);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable String email) {
        service.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}