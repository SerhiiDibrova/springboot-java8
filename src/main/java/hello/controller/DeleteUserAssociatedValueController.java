package hello.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.repository.DatabaseConnection;
import hello.controller.SuccessResponse;
import hello.utils.DatabaseConnectionUtils;
import org.apache.commons.validator.routines.EmailValidator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
public class DeleteUserAssociatedValueController {

    @DeleteMapping("/user")
    public SuccessResponse deleteUserAssociatedValue(@RequestParam("email") String email) {
        if (!EmailValidator.getInstance().isValid(email)) {
            throw new IllegalArgumentException("Invalid email");
        }

        try (Connection connection = DatabaseConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE email = ?")) {

            statement.setString(1, email);
            statement.executeUpdate();

            return new SuccessResponse("User associated value deleted successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}