

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hello.model.EmployeeProject;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {

}