package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findTopByDefaultTrueAndRoleId(Long roleId);
    
    Optional<User> findByDefaultTrueAndRoleId(Long roleId);
}