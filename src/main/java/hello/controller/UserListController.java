package hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.model.User;
import hello.repository.UserRepository;
import hello.controller.SuccessResponse;

import java.util.List;

@RestController
public class UserListController {

    private static final Logger logger = LoggerFactory.getLogger(UserListController.class);
    private static final int MAX_LIMIT = 100;
    private static final int MIN_LIMIT = 1;
    private static final int MIN_OFFSET = 0;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<SuccessResponse> getUsers(
        @RequestParam(defaultValue = "0") int offset,
        @RequestParam(defaultValue = "10") int limit
    ) {
        try {
            validateLimitAndOffset(limit, offset);
            List<User> users = userRepository.findAll(offset, limit);
            SuccessResponse response = new SuccessResponse(users);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error occurred while fetching users", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private void validateLimitAndOffset(int limit, int offset) {
        if (limit < MIN_LIMIT || limit > MAX_LIMIT) {
            throw new IllegalArgumentException("Invalid limit. Limit should be between " + MIN_LIMIT + " and " + MAX_LIMIT);
        }
        if (offset < MIN_OFFSET) {
            throw new IllegalArgumentException("Invalid offset. Offset should be greater than or equal to " + MIN_OFFSET);
        }
    }
}