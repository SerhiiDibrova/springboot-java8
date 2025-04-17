

package hello.service;

import hello.dto.DeptBudgetDTO;
import hello.exception.DepartmentNotFoundException;
import hello.exception.RepositoryException;
import hello.repository.DepartmentRepository;
import hello.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeptBudgetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeptBudgetService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public DeptBudgetDTO recalculateDeptBudget(Long departmentId) {
        if (departmentId == null) {
            throw new NullPointerException("Department ID is null");
        }

        try {
            List<Long> employeeIds = employeeRepository.getEmployeeIdsByDepartment(departmentId);
            if (employeeIds == null || employeeIds.isEmpty()) {
                LOGGER.info("No employees found for department with ID " + departmentId);
            }

            Double totalSalary = employeeRepository.getTotalSalaryByDepartment(departmentId);
            departmentRepository.updateBudget(departmentId, totalSalary);

            DeptBudgetDTO deptBudgetDTO = new DeptBudgetDTO();
            deptBudgetDTO.setDepartmentId(departmentId);
            deptBudgetDTO.setTotalSalary(totalSalary);
            deptBudgetDTO.setEmployeeIds(employeeIds);

            return deptBudgetDTO;
        } catch (RepositoryException e) {
            LOGGER.error("Repository exception occurred while recalculating department budget", e);
            throw e;
        } catch (Exception e) {
            LOGGER.error("Error occurred while recalculating department budget", e);
            throw new RuntimeException(e);
        }
    }
}