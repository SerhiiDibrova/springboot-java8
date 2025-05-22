package hello.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseRepositoryImpl implements DatabaseRepository {
    private String url = "jdbc:mysql://localhost:3306/yourdatabase";
    private String user = "yourusername";
    private String password = "yourpassword";

    @Override
    public void Save(String data) {
        String sql = "INSERT INTO reports (data) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, data);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}