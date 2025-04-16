

package hello.repository;

import hello.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT SUM(e.salary) FROM Employee e WHERE e.department.id = :deptId")
    Double getTotalSalaryByDeptId(@Param("deptId") Long deptId);
}