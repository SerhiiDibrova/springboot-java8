package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hello.entity.UserDB;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDB, Integer> {
    
    @Query("SELECT u FROM UserDB u JOIN u.role r WHERE u.default = 1 AND r.role = 'system'")
    Optional<UserDB> findDefaultManager();
}