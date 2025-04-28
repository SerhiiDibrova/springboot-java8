package hello.controller;

import hello.model.UserDTO;
import hello.model.UserCreateRequest;
import hello.model.UserResponse;
import hello.model.UserListResponse;
import hello.service.UserService;
import hello.service.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final ResponseService responseService;

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

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        UserResponse userResponse = service.createUser(userCreateRequest);
        return ResponseEntity.ok(responseService.success_response(userResponse));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable String email) {
        service.deleteUser(email);
        return ResponseEntity.ok(responseService.success_response(Map.of("message", "User deleted successfully")));
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String email) {
        UserResponse userResponse = service.getUserByEmail(email);
        if(userResponse == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping
    public ResponseEntity<UserListResponse> listUsers(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "10") int limit) {
        UserListResponse userListResponse = service.listUsers(offset, limit);
        return ResponseEntity.ok(responseService.success_response(userListResponse));
    }
}