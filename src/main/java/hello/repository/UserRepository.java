package hello.repository;

import hello.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN u.roles r WHERE u.defaultValue = 1 AND r.name = 'system'")
    Optional<User> findDefaultManager();

    default User getDefaultManager() {
        return findDefaultManager().orElseThrow(() -> new RuntimeException("No default manager found"));
    }
}