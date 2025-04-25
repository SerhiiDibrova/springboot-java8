```java
package hello.controller;

import hello.model.UserResponse;
import hello.model.ErrorResponse;
import hello.model.SuccessResponse;
import hello.utils.DatabaseConnectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAssociatedValueController {

    private final DatabaseConnectionUtils databaseConnectionUtils;

    @Autowired
    public UserAssociatedValueController(DatabaseConnectionUtils databaseConnectionUtils) {
        this.databaseConnectionUtils = databaseConnectionUtils;
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserAssociatedValue(@RequestParam("email") String email) {
        if (email == null || email.isEmpty()) {
            return errorResponse("Email is required", HttpStatus.BAD_REQUEST);
        }

        DataSource dataSource = databaseConnectionUtils.getDatabaseConnection();
        UserResponse userResponse = queryDatabase(dataSource, email);
        if (userResponse != null) {
            return successResponse(userResponse);
        } else {
            return errorResponse("User not found", HttpStatus.NOT_FOUND);
        }
    }

    private UserResponse queryDatabase(DataSource dataSource, String email) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?")) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    UserResponse userResponse = new UserResponse();
                    userResponse.setEmail(resultSet.getString("email"));
                    userResponse.setName(resultSet.getString("name"));
                    return userResponse;
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    private ResponseEntity<SuccessResponse> successResponse(UserResponse userResponse) {
        SuccessResponse successResponse = new SuccessResponse(userResponse);
        return ResponseEntity.ok(successResponse);
    }

    private ResponseEntity<ErrorResponse> errorResponse(String message, HttpStatus httpStatus) {
        ErrorResponse errorResponse = new ErrorResponse(message);
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }
}