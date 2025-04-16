

package hello.repository;

import hello.entity.NameEntity;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Proc13Repository {

    private final DataSource dataSource;

    public Proc13Repository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertName(NameEntity nameEntity) {
        String sql = "INSERT INTO table_13 (name) VALUES (?)";
        try (Connection connection = dataSource.getConnection(); 
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nameEntity.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}