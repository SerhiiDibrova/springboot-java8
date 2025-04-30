package hello.repository;

import hello.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query(value = "SELECT u.id FROM users u JOIN roles r ON u.role_id = r.id WHERE u.default = 1 AND r.role = 'system' LIMIT 1", nativeQuery = true)
    Optional<User> findDefaultManager();
}