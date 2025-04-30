package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import hello.entity.Role;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByUsers_Id(Integer userId);
    
    @Query("SELECT r FROM Role r ORDER BY r.name")
    List<Role> findAllSortedByName();
}