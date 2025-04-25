package hello.controller;

import model.User;
import model.SuccessResponse;
import service.UserService;
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
    public User getUserById(@PathVariable int id) {
        return service.getUser(id);
    }

    @PostMapping("/associated-value/{email}")
    public SuccessResponse createUserAssociatedValue(@PathVariable String email, @RequestBody User userIn) {
        return service.createUserAssociatedValue(email, userIn);
    }
}