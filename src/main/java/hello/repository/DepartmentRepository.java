

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import hello.model.Department;
import java.lang.Long;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Modifying
    @Query("UPDATE Department d SET d.budget = ?2 WHERE d.id = ?1")
    void updateBudget(Long id, double budget);

    @Query("SELECT d.budget FROM Department d WHERE d.id = ?1")
    double getBudget(Long id);

    @Query("SELECT MAX(d.id) FROM Department d")
    Long findNewDeptId();

    @Override
    <S extends Department> S save(S entity);
}