

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.model.DepartmentBudgetLog;
import java.lang.Long;

@Repository
public interface DepartmentBudgetLogRepository extends JpaRepository<DepartmentBudgetLog, Long> {

    default DepartmentBudgetLog save(DepartmentBudgetLog departmentBudgetLog) {
        if (departmentBudgetLog == null) {
            throw new NullPointerException("DepartmentBudgetLog object is null");
        }
        try {
            return saveAndFlush(departmentBudgetLog);
        } catch (Exception e) {
            throw new RuntimeException("Error saving DepartmentBudgetLog", e);
        }
    }
}