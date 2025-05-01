package hello.repository;

import hello.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u JOIN Role r ON u.roleId = r.id WHERE u.isDefault = true AND r.role = 'system'")
    Optional<User> findDefaultManager();
}