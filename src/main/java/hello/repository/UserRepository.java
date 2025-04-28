package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

import hello.entity.UserDB;

@Repository
public interface UserRepository extends JpaRepository<UserDB, Long> {
    
    Optional<UserDB> findByEmail(String email);
    
    void deleteByEmail(String email);
    
    boolean existsByEmail(String email);
    
    List<UserDB> findAll(Pageable pageable);
}