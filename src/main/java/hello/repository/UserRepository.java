package hello.repository;

import hello.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional(readOnly = true)
    Optional<User> findTopByDefaultTrueAndRoleIdIn(List<Integer> roleIds);
}