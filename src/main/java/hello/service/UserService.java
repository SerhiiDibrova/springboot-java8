package hello.service;

import hello.model.SuccessResponse;
import hello.model.User;
import hello.repository.DatabaseConnection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Map;

public class UserService {
    private final DatabaseConnection dbConnection;

    public UserService(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public SuccessResponse createUserAssociatedValue(String email, User userIn) {
        if (userIn.getValue() == null) {
            throw new RuntimeException("User value cannot be null");
        }
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dbConnection.getDataSource());
            String sql = "INSERT INTO user_associated_values (email, value) VALUES (:email, :value) ON CONFLICT (email) DO UPDATE SET value = :value";
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            namedParameterJdbcTemplate.update(sql, Map.of("email", email, "value", userIn.getValue()));
            return new SuccessResponse("User associated value created successfully");
        } catch (Exception e) {
            throw new RuntimeException("Failed to create user associated value", e);
    }
}