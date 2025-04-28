package hello.repository;

import hello.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findFirstByDefaultAndRole_Role(boolean defaultValue, String role);
}