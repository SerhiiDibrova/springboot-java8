

package hello.service;

import hello.model.Department;
import hello.model.DepartmentBudgetLog;
import hello.repository.DepartmentBudgetLogRepository;
import hello.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Objects;

@Service
public class DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    private final DepartmentBudgetLogRepository departmentBudgetLogRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentBudgetLogRepository departmentBudgetLogRepository, DepartmentRepository departmentRepository) {
        this.departmentBudgetLogRepository = departmentBudgetLogRepository;
        this.departmentRepository = departmentRepository;
    }

    public void logBudgetChange(@Valid Department department) {
        if (Objects.isNull(department)) {
            LOGGER.error("Department object is null");
            throw new NullPointerException("Department object is null");
        }

        DepartmentBudgetLog departmentBudgetLog = new DepartmentBudgetLog();
        departmentBudgetLog.setDepartment(department);
        departmentBudgetLog.setBudget(department.getBudget());
        try {
            departmentBudgetLogRepository.save(departmentBudgetLog);
        } catch (Exception e) {
            LOGGER.error("Error logging budget change", e);
            throw new RuntimeException("Error logging budget change", e);
        }
    }

    public int insertDepartment(String deptName, double budget) {
        if (Objects.isNull(deptName) || deptName.isEmpty()) {
            LOGGER.error("Department name is null or empty");
            throw new NullPointerException("Department name is null or empty");
        }

        Department department = new Department();
        department.setDeptName(deptName);
        department.setBudget(budget);
        try {
            departmentRepository.save(department);
            return departmentRepository.findNewDeptId();
        } catch (Exception e) {
            LOGGER.error("Error inserting department", e);
            throw new RuntimeException("Error inserting department", e);
        }
    }
}