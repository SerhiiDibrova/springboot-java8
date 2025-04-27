package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findTopByDefaultAndRole_Role(Integer defaultValue, String role);
}