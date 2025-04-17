

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.model.DepartmentBudgetLog;

@Repository
public interface DepartmentBudgetLogRepository extends JpaRepository<DepartmentBudgetLog, Long> {
}