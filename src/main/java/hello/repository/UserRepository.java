package hello.repository;

import hello.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findTopByDefaultTrueAndRole_Role(String role);

    default Optional<User> findUserByRole(String role) {
        try {
            return findTopByDefaultTrueAndRole_Role(role);
        } catch (DataAccessException e) {
            // Log the exception (logging mechanism should be implemented)
            return Optional.empty();
        }
    }
}