package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    
    @Query("SELECT m FROM Manager m WHERE m.role = :role AND m.isDefault = true")
    Manager findFirstByRoleAndIsDefault(@Param("role") String role);
    
    @Query("SELECT m.id FROM Manager m WHERE m.role = :role AND m.isDefault = true")
    Long findDefaultManagerIdByRole(@Param("role") String role);
}