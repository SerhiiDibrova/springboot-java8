package hello.repository;

import hello.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u JOIN u.role r WHERE u.default = true AND r.role = :role")
    Optional<User> findTopByDefaultTrueAndRole_Role(@Param("role") String role);
}