package hello.controller;

import hello.model.UserDTO;
import hello.service.UserService;
import org.h2.engine.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    // Spring will auto-wire a bean of type UserService
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        UserDTO userDTO = service.getById(id);
        if(userDTO == null) { return ResponseEntity.notFound().build(); }
        return ResponseEntity.ok(userDTO);
    }
}
