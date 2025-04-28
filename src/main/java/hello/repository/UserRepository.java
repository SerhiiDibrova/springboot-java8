package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import hello.entity.UserDB;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDB, Long> {
    
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user_db (email, name, ...) VALUES (:email, :name, ...) ON DUPLICATE KEY UPDATE name = :name, ...", nativeQuery = true)
    void upsertUser(@Param("email") String email, @Param("name") String name, ...);

    Optional<UserDB> findByEmail(String email);

    boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserDB u WHERE u.email = :email")
    void deleteByEmail(@Param("email") String email);

    @Query("SELECT u FROM UserDB u")
    List<UserDB> findAllUsers(Pageable pageable);
}