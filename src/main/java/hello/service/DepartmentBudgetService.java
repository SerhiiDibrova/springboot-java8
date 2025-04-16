

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.repository.DepartmentRepository;
import hello.repository.EmployeeRepository;

@Service
public class DepartmentBudgetRecalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentBudgetRecalculator.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public void recalculateDepartmentBudget(Long deptId) {
        if (deptId == null) {
            LOGGER.error("Department ID is null");
            throw new IllegalArgumentException("Department ID cannot be null");
        }

        Double totalSalary = employeeRepository.getTotalSalaryByDeptId(deptId);
        if (totalSalary == null) {
            LOGGER.error("Total salary is null for department ID {}", deptId);
            throw new RuntimeException("Total salary is null for department ID " + deptId);
        }

        Double currentBudget = departmentRepository.getBudgetByDeptId(deptId);
        if (currentBudget == null) {
            LOGGER.error("Current budget is null for department ID {}", deptId);
            throw new RuntimeException("Current budget is null for department ID " + deptId);
        }

        double newBudget;
        try {
            newBudget = currentBudget - totalSalary;
        } catch (ArithmeticException e) {
            LOGGER.error("Arithmetic overflow occurred while calculating new budget for department ID {}", deptId, e);
            throw new RuntimeException("Arithmetic overflow occurred while calculating new budget for department ID " + deptId, e);
        }

        departmentRepository.updateBudgetByDeptId(deptId, newBudget);
        LOGGER.info("Department budget recalculated successfully for department ID {}", deptId);
    }
}