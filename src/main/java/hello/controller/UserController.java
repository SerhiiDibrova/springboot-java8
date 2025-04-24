package hello.controller;
import model.User;
import service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service = new UserService();

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return service.getUser(id);
    }
}
