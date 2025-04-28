package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import hello.entity.UserDB;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDB, Long> {
    void deleteByEmail(String email);
    boolean existsByEmail(String email);
    List<UserDB> findAllUsers(int offset, int limit);
    UserDB findByEmail(String email);
    
    default List<UserDB> findAllUsers(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset / limit, limit);
        return findAll(pageable).getContent();
    }
}