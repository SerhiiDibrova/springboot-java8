package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hello.entity.UserDB;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDB, Long> {
    
    @Modifying
    @Query(value = "INSERT INTO users (email, value) VALUES (:email, :value) ON DUPLICATE KEY UPDATE value = :value", nativeQuery = true)
    void upsertUser(@Param("email") String email, @Param("value") String value);
    
    UserDB findByEmail(String email);
    
    @Query(value = "SELECT * FROM users LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<UserDB> findAllUsers(@Param("offset") int offset, @Param("limit") int limit);
}