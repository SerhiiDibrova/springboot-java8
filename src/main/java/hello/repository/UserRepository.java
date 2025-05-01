package hello.repository;

import hello.entity.User;
import hello.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u JOIN u.role r WHERE u.default = true AND r.role = 'system'")
    Optional<User> findDefaultManager();
}