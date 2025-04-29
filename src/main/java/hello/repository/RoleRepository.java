package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Future custom query methods can be defined here
}