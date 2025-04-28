package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;
import hello.entity.UserDB;

@Repository
public interface UserRepository extends JpaRepository<UserDB, Long> {
    Optional<UserDB> findByEmail(String email);
    boolean existsByEmail(String email);
    void deleteByEmail(String email);
    
    @Query(value = "SELECT u FROM UserDB u")
    List<UserDB> findUsersWithPagination(int offset, int limit);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO UserDB (email, ...) VALUES (:email, ...) ON DUPLICATE KEY UPDATE ...", nativeQuery = true)
    void upsertUser(String email, ...);
}