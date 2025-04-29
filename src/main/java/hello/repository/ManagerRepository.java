package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Optional<Manager> findTopByDefaultTrueAndRoleId(Integer roleId);
}