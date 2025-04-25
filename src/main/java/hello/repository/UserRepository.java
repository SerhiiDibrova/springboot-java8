package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query("SELECT u.id FROM User u WHERE u.default = 1 AND u.role = 'system' ORDER BY u.id ASC")
    Long findDefaultManagerId();
}