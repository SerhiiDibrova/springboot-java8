

package hello.repository;

import hello.entity.Employee;
import hello.entity.EmployeeDTO;
import hello.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee save(Employee employee);

    List<Employee> findByDeptId(Long deptId);

    @Query("UPDATE Employee e SET e.salary = :newSalary WHERE e.id = :employeeId")
    @Transactional
    void updateSalary(@Param("employeeId") Long employeeId, @Param("newSalary") Double newSalary);

    @Query("SELECT e.id FROM Employee e ORDER BY e.id DESC")
    Long findNewlyGeneratedEmployeeId();
}