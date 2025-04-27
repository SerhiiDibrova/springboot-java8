package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findTopByDefaultAndRole(String role);
}